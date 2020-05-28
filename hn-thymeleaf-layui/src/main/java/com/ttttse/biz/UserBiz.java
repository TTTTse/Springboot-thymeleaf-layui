package com.ttttse.biz;

import com.github.pagehelper.PageInfo;
import com.ttttse.entity.MyUserInfo;

import java.util.List;

/**
 * @program: hn-thymeleaf-layui
 * @description: 用户相关的业务方法
 * @author: ttttse
 * @create: 2020-05-23 20:58
 **/

public interface UserBiz {
    MyUserInfo selectUserByUsername(String username);
    PageInfo<MyUserInfo> selectAllUser(int page, int limit);
    int insertSelective(MyUserInfo record);
}
