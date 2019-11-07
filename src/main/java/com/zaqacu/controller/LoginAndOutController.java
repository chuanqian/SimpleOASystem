package com.zaqacu.controller;

import com.zaqacu.service.LoginAndOutService;
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
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;
import java.util.Map;

@Controller
public class LoginAndOutController {

    @Autowired
    private UserLoginService userLoginService;
    @Autowired
    private LoginAndOutService loginAndOutService;

    /**
     * 登录页面
     * @return
     */
    @RequestMapping("toLogin.login")
    public String toLogin() {
        return "jsp/login";
    }

    /**
     * 员工登录
     * @param userName 用户名
     * @param userPassword  密码
     * @param map 装入信息
     * @param session
     * @return
     */
    @RequestMapping(value = "login.login", method = RequestMethod.POST)
    public String login(String userName, String userPassword, Map<String, Object> map, HttpSession session) {
        System.err.println(userName);
        System.err.println(userPassword);
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
        session.setAttribute("user", userLoginService.getOneUserLoginByUsername(userName));
        return "redirect:toIndex.do";

    }

    /**
     * 主页
     * @return
     */
    @RequestMapping("toIndex.do")
    public String toIndex() {
        return "jsp/index";
    }

    /**
     * 安全退出
     * @param httpServletRequest
     * @param response
     * @param session
     * @return
     */
    @RequestMapping(value = "Out.login")
    public String Out(HttpServletRequest httpServletRequest, HttpServletResponse response, HttpSession session) {
        Enumeration<String> enumeration = httpServletRequest.getSession().getAttributeNames();
        while (enumeration.hasMoreElements()) {
            String key = enumeration.nextElement().toString();
            httpServletRequest.getSession().removeAttribute(key);
        }
        Cookie[] cookie = httpServletRequest.getCookies();
        for (Cookie c : cookie) {
            if ("autoLogin".equals(c.getName())) {
                c.setMaxAge(0);
                response.addCookie(c);
            }
        }
        return "redirect:toLogin.login";
    }

    @RequestMapping("toHomePage.login")
    public String toHomePage(){
        return "jsp/homepage";
    }

    /**
     * 权限不够跳转的页面
     * @return
     */
    @RequestMapping("toError.login")
    public String toError(){
        return "jsp/error";
    }

    /**
     * 修改密码
     * @param staffUid
     * @param newPassword
     * @return
     */
    @RequestMapping(value = "/editPassword.enable",method={RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public boolean editPassword(String staffName,String staffUid,String newPassword){
        return userLoginService.editPassword(staffUid,newPassword);
    }

}
