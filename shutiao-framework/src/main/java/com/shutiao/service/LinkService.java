package com.shutiao.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.shutiao.domain.ResponseResult;
import com.shutiao.domain.entity.Link;


/**
 * 友链(Link)表服务接口
 *
 * @author makejava
 * @since 2022-02-13 13:40:55
 */
public interface LinkService extends IService<Link> {

    ResponseResult getAllLink();
}

