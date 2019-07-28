package com.gxa.miaoshacd.service;

import com.gxa.miaoshacd.entity.UserInfo;

public interface UserService {

    /**
     * 注册中验证用户名是否存在
     * @return 存在返回true，不存在返回false
     */
    boolean checkUserName(String userName);
    //注册
    boolean registUser(UserInfo userInfo);
    UserInfo userLogin(UserInfo userInfo);
    boolean userUpdate(UserInfo userInfo);
    boolean deleteUser(UserInfo userInfo);

}
