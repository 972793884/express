package com.star.mapper;

import com.star.vo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    @Insert("insert into user(name,password,nick_name,is_delete,is_locked,role,sign_in_time,last_login_time,this_login_time,phone,email) values(#{name},#{password},#{nickName},#{isDelete},#{isLocked},#{role},#{signInTime},#{lastLoginTime},#{thisLoginTime},#{phone},#{email})")
    Integer save(User user);

    @Update("update user set id=#{id},name=#{name},password=#{password},nick_name=#{nickName},is_delete=#{isDelete},is_locked=#{isLocked},role=#{role},sign_in_time=#{signInTime},last_login_time=#{lastLoginTime},this_login_time=#{thisLoginTime},phone=#{phone},email=#{email} where id=#{id}")
    Integer update(User user);
    @Select("select * from user where is_delete=0 and role=1")
    List<User> getUserList();
    @Select("select * from user where id=#{id} and is_delete=0")
    User getUserById(@Param("id") Integer id);
    @Select("select * from user where is_delete=0 and role=0")
    List<User> getAdminList();
}
