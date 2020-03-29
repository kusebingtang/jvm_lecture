package com.shengsiyuan.jvm.classloader;

/**
 * @author JiangBin
 * @create 2020-03-29 15:45
 */
public class MyTest17 {

    public static void main(String[] args) throws Exception {

        MyTest16 loader1 = new MyTest16("loader1");

        Class<?> mySampleClass = loader1.loadClass("com.shengsiyuan.jvm.classloader.MySample");

        System.out.println("mySampleClass hashCode:" + mySampleClass.hashCode());

        /**
         * 也就是注释之后则不会实例化MySample对象，既MySample构造方法不会被调用，因此也不会实例化MyCat对象，
         * 既没有对MyCat进行主动使用，这里就不会加载MyCat Class。其实类加载器会不会加载MyCat这是不一定的，这是因为如下原因：
         *
         * 类加载器并不需要等到某个类被“首次主动使用”时再加载它。
         * JVM规范允许类加载器在预料某个类将要被使用时就预先加载它，如果在预先加载的过程中遇到了.class文件缺失或存在错误，类加载器必须在程序首次主动使用该类时才报告错误（LinkageError错误）。
         * 如果这个类一直没有被程序主动使用，那么类加载器就不会报告错误。
         * 所以MyCat类虽说没有被初始化，那它到底有木有被加载可以通过给JVM增加"-XX:+TraceClassLoading"来看一下：
         */
//        Object object = mySampleClass.newInstance();


    }
}
