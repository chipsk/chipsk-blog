package com.shutiao.service;

import com.shutiao.domain.ResponseResult;
import com.shutiao.domain.entity.User;

public interface BlogLoginService {

    ResponseResult login(User user);

    ResponseResult logout();
}
