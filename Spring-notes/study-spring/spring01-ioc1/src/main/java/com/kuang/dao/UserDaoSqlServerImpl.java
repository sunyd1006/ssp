package com.kuang.dao;

public class UserDaoSqlServerImpl implements UserDao {

    @Override
    public void getUser() {
        System.out.println("Server获取用户数据");
    }
}
