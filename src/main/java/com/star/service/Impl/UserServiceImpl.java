package com.star.service.Impl;

import com.star.service.UserService;
import com.star.mapper.UserMapper;
import com.star.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public Integer save(User user) {
        if (user.getId()==null){
            user.setSignInTime(new Date());
            user.setRole(1);
            user.setIsDelete(0);
            user.setIsLocked(0);
            return userMapper.save(user);
        } else
            return userMapper.update(user);
    }

    @Override
    public List<User> getUserList() {
        return  userMapper.getUserList();
    }

    @Override
    public User getUserById(Integer id) {
        return userMapper.getUserById(id);
    }

    @Override
    public List<User> getAdminList() {
        return userMapper.getAdminList();
    }
}
