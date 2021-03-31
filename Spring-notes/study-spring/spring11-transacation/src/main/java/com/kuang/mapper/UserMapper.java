package com.kuang.mapper;

import com.kuang.pojo.User;

import java.util.List;

public interface UserMapper {
    List<User> selectUser();
    //添加一个用户
    Integer addUser(User user);

    //删除一个用户
    Integer deleteUser(int id);
}