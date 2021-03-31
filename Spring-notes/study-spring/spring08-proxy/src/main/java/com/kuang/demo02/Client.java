package com.kuang.demo02;

/**
 * @author ：ltb
 * @date ：2020/7/14
 */
public class Client {

    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        UserServicePorxy userServicePorxy = new UserServicePorxy();
        userServicePorxy.setUserService(userService);
        userServicePorxy.add();
    }
}
