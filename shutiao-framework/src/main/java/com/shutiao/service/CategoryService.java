package com.shutiao.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.shutiao.domain.ResponseResult;
import com.shutiao.domain.entity.Category;
import org.springframework.stereotype.Service;


/**
 * 分类表(Category)表服务接口
 *
 * @author makejava
 * @since 2022-02-11 01:07:49
 */
public interface CategoryService extends IService<Category> {

    ResponseResult getCategoryList();
}

