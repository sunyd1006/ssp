package com.kuang.demo02;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ：ltb
 * @date ：2020/7/14
 */
@Data@NoArgsConstructor@AllArgsConstructor
public class UserServicePorxy implements UserService {

    private UserService userService;
    @Override
    public void add() {
        log("add");
        userService.add();
    }

    @Override
    public void delete() {
        log("delete");
        userService.delete();
    }

    @Override
    public void update() {
        log("update");
        userService.update();
    }

    @Override
    public void query() {
        log("query");
        userService.query();
    }

    public void log(String msg){
        System.out.println("使用了" + msg + "方法");
    }
}
