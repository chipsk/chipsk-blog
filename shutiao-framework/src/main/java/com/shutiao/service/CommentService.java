package com.shutiao.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.shutiao.domain.ResponseResult;
import com.shutiao.domain.entity.Comment;


/**
 * 评论表(Comment)表服务接口
 *
 * @author makejava
 * @since 2022-02-17 19:56:28
 */
public interface CommentService extends IService<Comment> {

    ResponseResult commentList(String commentType, Long articleId, Integer pageNum, Integer pageSize);

    ResponseResult addComment(Comment comment);
}

