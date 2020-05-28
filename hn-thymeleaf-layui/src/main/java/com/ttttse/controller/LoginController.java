package com.ttttse.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: hn-thymeleaf-layui
 * @description: 登录页面控制器
 * @author: ttttse
 * @create: 2020-05-26 20:41
 **/
@Controller
public class LoginController {
    /**
     * 将请求tologin转发到login.html
     * @return
     */
    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }
    @RequestMapping("/login")
    public String login(Model model,String username,String password){
        //登录验证
        System.out.println(username+password);
        //获取shiro的主体
        Subject subject = SecurityUtils.getSubject();
        //构建用户登录令牌
        UsernamePasswordToken token= new UsernamePasswordToken(username,password);
        //AuthenticationToken token
        //subject.login(token);
        try {
            subject.login(token);
        }catch (UnknownAccountException e){
            model.addAttribute("message","用户名错误");
            return "login";
        }catch (IncorrectCredentialsException e){
            model.addAttribute("message","密码错误");
            return "login";
        }

        return "showUserLayui";
    }
}
