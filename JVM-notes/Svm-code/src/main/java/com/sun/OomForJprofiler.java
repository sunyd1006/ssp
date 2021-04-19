package com.sun;

import java.util.ArrayList;

/*
    -Xms 设置初始化内存大小
    -Xmx 设置最大分配内存
    -XX:+HeapDumpOnOutOfMemoryError
    -XX:+PrintGCDetails

    -Xms1m -Xms2m -XX:+HeapDumpOnOutOfMemoryError
 */

public class OomForJprofiler {
    byte[] array = new byte[1024*1024];

    public static void main(String[] args) {
        ArrayList<OomForJprofiler> list = new ArrayList<>();
        int count = 0;

        try{
            while (true){
                list.add(new OomForJprofiler());
                count++;
            }
        }catch (Error e){
            System.out.println("Error " + count);
            e.printStackTrace();
        }
    }
}
