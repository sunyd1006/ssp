package com.kuang.mapper;

import com.kuang.pojo.User;

import java.util.List;

/**
 * @author ：ltb
 * @date ：2020/7/15
 */
public interface UserMapper {

    List<User> selectAllUsers();
}
