package com.shutiao.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.shutiao.domain.ResponseResult;
import com.shutiao.domain.entity.User;


/**
 * 用户表(User)表服务接口
 *
 * @author makejava
 * @since 2022-02-13 14:07:23
 */
public interface UserService extends IService<User> {

    ResponseResult userInfo();

    ResponseResult updateUserInfo(User user);

    ResponseResult register(User user);
}

