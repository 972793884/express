package com.star.controller;

import com.star.Utils.Ret;
import com.star.service.LoginService;
import com.star.service.UserService;
import com.star.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {
    @Autowired
    UserService userService;
    @Autowired
    LoginService loginService;

    @PostMapping("doRegister")
    Ret doRegister(User user) {
        User user1 = loginService.findByName(user.getName());
        Integer result=-1;
        if (user1 == null)
            result = userService.save(user);
        return result > 0 ? Ret.ok().set("msg", "ok") : Ret.fail().set("msg", "注册失败,账号已被注册!");
    }

    @GetMapping("checkName")
    Object[] checkName(String fieldId, String fieldValue, String extraData) {
        Object result[] = new Object[2];
        User user = loginService.findByName(fieldValue);
        result[0] = fieldId;
        result[1] = user == null ? true : false;
        return result;
    }

}
