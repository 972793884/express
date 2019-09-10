package com.star.controller;

import com.star.Utils.Ret;
import com.star.service.LoginService;
import com.star.service.UserService;
import com.star.vo.User;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("user")
@RestController
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    LoginService loginService;


    @GetMapping("getUserList")
    List<User> getUserList(){
        return userService.getUserList();
    }
    @GetMapping("getThisLoginUser")
    User getThisLoginUser(){
        String name = (String)SecurityUtils.getSubject().getPrincipal();
        User user =loginService.findByName(name);
        return user;
    }
    @GetMapping("getAdminList")
    List<User> getAdminList(){
        return userService.getAdminList();
    }
    @GetMapping("getUserById")
    User getUserById(Integer id){
        return  userService.getUserById(id);
    }
    @PostMapping("saveUser")
    Ret saveUser(User user){
        if ("".equals(user.getPassword().trim())){
            user.setPassword(null);
        }
       return user.save()>0?Ret.ok():Ret.fail();
    }
    @GetMapping("delUser")
    Ret delUser(Integer id){
        User user=new User();
       return user.delete(id)>0?Ret.ok():Ret.fail();
    }
}
