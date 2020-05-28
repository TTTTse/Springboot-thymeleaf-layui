package com.ttttse.biz.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ttttse.biz.UserBiz;
import com.ttttse.dao.MyUserInfoMapper;
import com.ttttse.entity.MyUserInfo;
import com.ttttse.shiro.ShiroUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * @program: hn-thymeleaf-layui
 * @description: 业务接口实现类
 * @author: ttttse
 * @create: 2020-05-23 21:01
 * 请求-->controller-->service(biz)-->dao-->DB
 **/
@Service
public class UserBizImpl implements UserBiz {
    @Autowired
    private MyUserInfoMapper myUserInfoMapper;

    /**
     * 按照用户名查找用户信息
     * @param username
     * @return
     */
    @Override
    public  MyUserInfo selectUserByUsername(String username){
        return myUserInfoMapper.selectUserByUsername(username);
    }

    @Override
    public PageInfo<MyUserInfo> selectAllUser(int page, int limit) {
        //开始分页，第一个参数是当前第几页，第二个是一页显示多少行
        PageHelper.startPage(page,limit);
        List<MyUserInfo> myUserInfos = myUserInfoMapper.selectAllUser();
        //结束分页 pageInfo封装了分页之后的数据
        PageInfo<MyUserInfo> pageInfo =new PageInfo(myUserInfos);
        return pageInfo;
    }

    @Override
    public int insertSelective(MyUserInfo record) {
        //此处要进行密码明文加盐加密
        String salt = UUID.randomUUID().toString();
        String message = record.getPassword();
        String encryptionBySalt = ShiroUtil.encryptionBySalt(salt, message);
        record.setPassword(encryptionBySalt);
        record.setSalt(salt);
        return myUserInfoMapper.insertSelective(record);
    }
}
