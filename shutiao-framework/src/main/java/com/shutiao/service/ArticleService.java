package com.shutiao.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.shutiao.domain.ResponseResult;
import com.shutiao.domain.entity.Article;

public interface ArticleService extends IService<Article> {

    ResponseResult hotArticleList();

    ResponseResult articleList(Integer pageNum, Integer pageSize, Long categoryId);

    ResponseResult getArticleDetail(Long id);
}
