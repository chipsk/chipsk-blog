package com.shutiao.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shutiao.constants.SystemConstants;
import com.shutiao.domain.ResponseResult;
import com.shutiao.domain.entity.Comment;
import com.shutiao.domain.vo.CommentVo;
import com.shutiao.domain.vo.PageVo;
import com.shutiao.enums.AppHttpCodeEnum;
import com.shutiao.exception.SystemException;
import com.shutiao.mapper.CommentMapper;
import com.shutiao.service.CommentService;
import com.shutiao.service.UserService;
import com.shutiao.utils.BeanCopyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 评论表(Comment)表服务实现类
 *
 * @author makejava
 * @since 2022-02-17 19:56:28
 */
@Service("CommentService")
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

    @Autowired
    private UserService userService;

    @Override
    public ResponseResult commentList(String commentType, Long articleId, Integer pageNum, Integer pageSize) {
        //查询对应文章的根评论
        LambdaQueryWrapper<Comment> queryWrapper = new LambdaQueryWrapper<>();
        //对articleId进行判断
        queryWrapper.eq(SystemConstants.ARTICLE_COMMENT.equals(commentType), Comment::getArticleId, articleId);
        //根评论id为-1
        queryWrapper.eq(Comment::getRootId, -1);//这里注意定义字面量, 而不是使用-1常量

        //评论类型
        queryWrapper.eq(Comment::getType, commentType);
        //分页查询
        Page<Comment> page = new Page<>(pageNum, pageSize);
        page(page, queryWrapper);

        List<CommentVo> commentVoList = toCommentVoList(page.getRecords());
        //查询对应的子评论
        //赋值
        List<CommentVo> collect = commentVoList.stream()
                .peek(commentVo -> commentVo.setChildren(getChildrenCommentList(commentVo.getId())))
                .collect(Collectors.toList());
        return ResponseResult.okResult(new PageVo(collect, page.getTotal()));
    }

    /**
     * 添加评论
     * @param comment
     * @return
     */
    @Override
    public ResponseResult addComment(Comment comment) {
        //评论内容不能为空
        if (!StringUtils.hasText(comment.getContent())) {
            throw new SystemException(AppHttpCodeEnum.CONTEXT_NOT_NULL);
        }
        save(comment);
        return ResponseResult.okResult();
    }

    /**
     * 根据根评论的id查询对应的子评论的集合
     * @param rootId 根评论id
     * @return
     */
    private List<CommentVo> getChildrenCommentList(Long rootId) {

        LambdaQueryWrapper<Comment> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Comment::getRootId, rootId);
        queryWrapper.orderByDesc(Comment::getCreateTime);
        List<Comment> comments = list(queryWrapper);
        List<CommentVo> commentVos = toCommentVoList(comments);
        return commentVos;
    }


    private List<CommentVo> toCommentVoList(List<Comment> list) {
        List<CommentVo> commentVos = BeanCopyUtils.copyBeanList(list, CommentVo.class);
        //遍历vo集合
        //通过createBy查询用户昵称并赋值
        //通过toCommentUserId查询用户的昵称并赋值
        return commentVos.stream()
                .peek(commentVo -> {
                    commentVo.setUsername(userService.getById(commentVo.getCreateBy()).getNickName());
                    if (commentVo.getToCommentUserId() != -1)
                        commentVo.setToCommentUserName(userService.getById(commentVo.getToCommentUserId()).getNickName());
                })
                .collect(Collectors.toList());
    }
}

