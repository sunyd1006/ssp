package com.sun;

public class TestForJVM {
    public static void main(String[] args) {
        // 最大可用内存，和硬件，和java.long.MAX_VALUE有关
        long max = Runtime.getRuntime().maxMemory();

        // 最大可用内存，和硬件，和java.long.MAX_VALUE有关
        long total = Runtime.getRuntime().totalMemory();

        System.out.println("max=" + max + "B\t"+ (max/(double)1024) + "KB\t" + (max/(double)1024/1024) + "MB" );
        System.out.println("total=" + total + "字节\t"+ (total/(double)1024) + "KB\t" + (total/(double)1024/1024) + "MB" );

        System.out.println("========== 调用死循环 =========");
//        HeapForJVM.a();
    }

    // 默认：总内存是电脑的1/4, 初始化1/64
    /*
        OOM:
            1. 尝试扩大 堆内存，查看结果
            2. 分析内存， 看一下那些地方 出了问题（专业工具）
        
        调优命令：
            -Xms 设置Java程序启动时的初始堆大小-- 初始化内存大小
            -Xmx 设置java程序能获得的最大堆大小-- 最大内存大小
            -XX:+HeapDumpOnOutOfMemoryError 使用改参数可以在内存溢出时导出这个堆信息
            -XX:+HeapDumpPath， 可以设置导出堆的存放路径
            -XX:+PrintGCDetails 打印GC垃圾回收信息
            -Xlog:gc*           用这个。
     */

    // -Xms526m -Xmx1027m -Xlog:gc*

    public static void a(){
        b();
    }

    public static void b(){
        a();
    }
}
