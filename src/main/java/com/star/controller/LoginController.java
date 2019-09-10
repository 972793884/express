package com.star.controller;

import com.star.Utils.Ret;
import com.star.service.Impl.UserServiceImpl;
import com.star.service.LoginService;
import com.star.service.UserService;
import com.star.vo.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
public class LoginController {
    @Autowired
    LoginService loginService;
    @Autowired
    UserService userService;

    @RequestMapping("login")
    public String index() {
        return "login.html";
    }

    @ResponseBody
    @RequestMapping("doLogin")
    public Ret login(HttpServletRequest request, @RequestParam("name") String name, @RequestParam("password") String password, HttpServletResponse response) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(
                name, password
        );

        try {
            subject.login(usernamePasswordToken);
            String loginName = (String) SecurityUtils.getSubject().getPrincipal();
            User user = loginService.findByName(loginName);
            user.setLastLoginTime(user.getThisLoginTime());
            user.setThisLoginTime(new Date());
            userService.save(user);
        } catch (UnknownAccountException e) {
            return Ret.fail().set("msg", "用户名和密码不正确");
        } catch (IncorrectCredentialsException e) {
            return Ret.fail().set("msg", "用户名和密码不正确");
        } catch (LockedAccountException e) {
            return Ret.fail().set("msg", "账号被锁定!请联系管理员");
        } catch (ExcessiveAttemptsException e) {
            return Ret.fail().set("msg", "未知错误!");
        } catch (AuthenticationException e) {
            return Ret.fail().set("msg", "未知错误!");
        }
        return Ret.ok().set("token", subject.getSession().getId());
    }
    @ResponseBody
    @RequestMapping("isLogin")
    Ret isLogin() {
        String loginName = (String) SecurityUtils.getSubject().getPrincipal();
        User u =loginService.findByName(loginName);
        return u==null?Ret.fail():Ret.ok().set("user",u);
    }
}
