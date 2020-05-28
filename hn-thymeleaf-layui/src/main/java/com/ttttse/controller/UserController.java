package com.ttttse.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ttttse.biz.UserBiz;
import com.ttttse.entity.LayUITable;
import com.ttttse.entity.MyUserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.security.auth.Subject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.ttttse.util.Constants.*;

/**
 * @program: hn-thymeleaf-layui
 * @description: Controller
 * @author: ttttse
 * @create: 2020-05-23 17:48
 **/

@Controller
public class UserController{
    @Autowired
    private UserBiz userBizImpl;


    @RequestMapping ("/toShowUserLayui")
    public String toShowUserLayui(){

        return "showUserLayui";
    }

    @RequestMapping ("/ShowUserLayui")
    @ResponseBody
    public Object ShowUserLayui(int page,int limit){
        //开始查询
        PageInfo<MyUserInfo> myUserInfoPageInfo = userBizImpl.selectAllUser(page, limit);
        LayUITable layUITable = new LayUITable();
        layUITable.setCode(0);
        layUITable.setMsg("返回消息");
        //设置分页之后的返回值
        layUITable.setCount(myUserInfoPageInfo.getTotal());
        layUITable.setData(myUserInfoPageInfo.getList());
        return layUITable;
    }

    @RequestMapping("/saveUser")
    @ResponseBody
    public Object saveUser(MyUserInfo userInfo){
        int i = userBizImpl.insertSelective(userInfo);
        Map map = new HashMap<>();
        if (i>0){
            map.put("code",successCode);
            map.put("message",saveSuccessMsg);
        }else {
            map.put("code",failCode);
            map.put("message",failMsg);
        }
        return map;
    }

}

