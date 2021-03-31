package com.kuang.demo01;

/**
 * @author ：ltb
 * @date ：2020/7/14
 */
public class Client {

    public static void main(String[] args) {
        Host host = new Host();
        Proxy proxy = new Proxy(host);
        proxy.seeHouse();
        proxy.rent();
        proxy.hetong();
        proxy.fare();
    }

}
