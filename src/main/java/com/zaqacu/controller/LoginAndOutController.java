package com.zaqacu.controller;

import com.zaqacu.service.UserLoginService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginAndOutController {

    @Autowired
    private UserLoginService userLoginService;

    @RequestMapping("toLogin.login")
    public String toLogin() {
        return "jsp/login";
    }

    @RequestMapping(value = "login.login", method = RequestMethod.POST)
    public String login(String userName, String userPassword, Map<String, Object> map, HttpSession session) {
//        System.out.println(userName);
//        System.out.println(userPassword);
        //获取shiro用户对象
        Subject subject = SecurityUtils.getSubject();
        //获取令牌对象
        UsernamePasswordToken token = new UsernamePasswordToken(userName, userPassword);
        try {
            //运行登录
            subject.login(token);
        } catch (UnknownAccountException e) {
            map.put("error", "此账户不存在");
            return "jsp/login";
        } catch (IncorrectCredentialsException e) {
            map.put("error", "密码错误");
            return "jsp/login";
        }
        session.setAttribute("user",userLoginService.getOneUserLoginByUsername(userName));
        return "redirect:toIndex.do";

    }

    @RequestMapping("toIndex.do")
    public String toIndex() {
        return "jsp/index";
    }

}
