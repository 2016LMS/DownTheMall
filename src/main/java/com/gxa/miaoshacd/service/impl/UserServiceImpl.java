package com.gxa.miaoshacd.service.impl;

import com.gxa.miaoshacd.dao.UserDao;
import com.gxa.miaoshacd.entity.UserInfo;
import com.gxa.miaoshacd.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public boolean checkUserName(String userName) {

        //查询数据库中userinfo表里面是否有这个用户数据

       UserInfo userInfo =  userDao.selectUserInfoByUserName(userName);

        return userInfo == null?false:true;
    }


    public boolean registUser(UserInfo userInfo){
        userDao.insertUser(userInfo);
        String userName2=userInfo.getUserName();
        UserInfo userInfo2 =  userDao.selectUserInfoByUserName(userName2);
         return userInfo2 == null?false:true;
    }

    public UserInfo userLogin(UserInfo userInfo){
        UserInfo userInfo3 = userDao.findByUserNameAndPassword(userInfo);
        return userInfo3;
    }

    public boolean userUpdate(UserInfo userInfo){
        userDao.updatePwd(userInfo);
        //String pwd2=userInfo.getUserPwd();
        UserInfo userInfo4 =userDao.findByUserNameAndPassword(userInfo);
        return userInfo4==null?true:false;
    }
    public boolean deleteUser(UserInfo userInfo){
        userDao.deleteUserByUserNameAndPassword(userInfo);
        String userName2=userInfo.getUserName();
        UserInfo userInfo5 = userDao.selectUserInfoByUserName(userName2);
        return userInfo5 == null?true:false;
    }
}
