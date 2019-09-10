package com.star.Utils;

import com.star.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class ShiroUtil {

    public Map<String, String> getPermissionMap() {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("/**/*.js", "anon");
        map.put("/*.html", "anon");
        map.put("/**/*.css", "anon");
        map.put("/images/*", "anon");
        map.put("/logout", "logout");
        map.put("/doLogin", "anon");
        map.put("/isLogin", "anon");
        map.put("/checkName", "anon");
        map.put("/doRegister", "anon");
        return map;
    }
}
