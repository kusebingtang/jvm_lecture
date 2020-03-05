package com.shengsiyuan.jvm.classloader;

class Patent {
    static int a = 3;

    static {
        System.out.println("Patent static block");
    }

}

class Child extends Patent {
    static int b = 4;

    static {
        System.out.println("Child static block");
    }
}

//接着由于"Child.b"子类静态变量的使用会导到它的父类进行初始化，所以"Parent static block"输出了，最后自己再初始化，所以"Child static block"输出了，
// 最终再输出要打印的变量的值，为了进一步查看类的加载信息，还是给JVM加上"-XX:+TraceClassLoading"参数来进行观测，如下：
/*
MyTest9 static block
[Loaded java.net.URI from /Library/Java/JavaVirtualMachines/jdk1.8.0_221.jdk/Contents/Home/jre/lib/rt.jar]
[Loaded com.shengsiyuan.jvm.classloader.Patent from file:/Users/zyh/Documents/JavaWorkSpace/jvm_lecture/out/production/classes/]
[Loaded java.net.URI$Parser from /Library/Java/JavaVirtualMachines/jdk1.8.0_221.jdk/Contents/Home/jre/lib/rt.jar]
[Loaded com.shengsiyuan.jvm.classloader.Child from file:/Users/zyh/Documents/JavaWorkSpace/jvm_lecture/out/production/classes/]
Patent static block
Child static block
4
 */
public class MyTest9 {

    static  {
        System.out.println("MyTest9 static block");
    }

    public static void main(String[] args) {

        System.out.println(Child.b);

    }
}
