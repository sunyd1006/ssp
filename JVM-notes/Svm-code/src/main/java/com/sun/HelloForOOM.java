package com.sun;

import java.util.Random;

public class HelloForOOM {
    public static void main(String[] args) {
        String str = "hello";
        while(true){
            str += str +new Random(1000000000).toString() + new Random(10000000).toString();
        }
    }

    // -Xms8m -Xmx16m -Xlog:gc*
    // -Xms8m -Xmx16m -XX:+PrintGCDetails
}
