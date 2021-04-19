/**
 * 主要：用于说明，双亲委派机制
 */
public class Student {
    @Override
    public String toString() {
        return "Student{}";
    }

    public static void main(String[] args) {
        Student student = new Student();
        System.out.println(student.getClass().getClassLoader().toString()); // AppClassLoader
    }

    /**
     * 1. 类加载器收到请求，AppClassLoader  ---> ExtClassLoader（D:Environment\java\jre\lib\ext)  ---> Bootstrap
     * 2. 讲这个请求委托给父类去完成，一直向上委托，直到启动类加载器（Bootstrap)
     * 3. 启动器检查 是否能够加载当前类，能够就加载结束，使用当前类，否则不能够就跑出异常。
     * 4. 重复步骤3.
     *
     * Class Not found: 是
     * null：
     */

}


//package java.lang;
//
//// Error:(1, 1) java: 程序包已存在于另一个模块中: java.base
//public class String {
//    @Override
//    public String toString() {
//        return "String{}";
//    }
//
//    public static void main(String[] args) {
//        String str = new String();
//        System.out.println(str.getClass().getClassLoader().toString()); // AppClassLoader
//    }
//
//}
