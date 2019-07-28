package com.gxa.miaoshacd.dao;

import com.gxa.miaoshacd.entity.UserInfo;
import org.apache.catalina.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserDao {

        //通过Mapper里的select查询语句使用username属性在数据库查找
        UserInfo selectUserInfoByUserName(String userName);
        void insertUser(UserInfo userInfo);
        UserInfo findByUserNameAndPassword(UserInfo userInfo);
        void updatePwd(UserInfo userInfo);
        void deleteUserByUserNameAndPassword(UserInfo userInfo);

}
