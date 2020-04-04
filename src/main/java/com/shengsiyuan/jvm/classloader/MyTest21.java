package com.shengsiyuan.jvm.classloader;

import java.lang.reflect.Method;

/**
 * @author JiangBin
 * @create 2020-03-29 16:47
 *
 *
 * 类加载器的双亲委托模型的好处：
 *
 * 1、可以确保Java核心库【如JDK中rt.jar里面的类】的安全：所有的Java应用至少会引用java.lang.Object类，也就是说在运行期，java.lang.Object这个类会被加载到Java虚拟机中；
 * 如果这个加载过程是由Java应用自己的类加载器所完成的，那么很可能就会在JVM中存在多个版本的java.lang.Object类，而且这些类之间还是不兼容的，相互不可见的（正是命名空间在发挥着作用）。
 * 所以可见是有很多的问题的，而借助于双亲委托机制，Java核心类库中的加载工作都是由启动类加载器来统一完成，从而确保了Java应用所使用的都是同一个版本的Java核心类，他们之间是相互兼容的。
 *
 * 2、可以确保Java核心类库所提供的类不会被自定义的类所替代，这样避免威胁JDK中的一些系统类：比如咱们自己定义了一个java.lang.Object，
 * 它是无论如何都不会被加载到JVM当中的，因为它一定是启动类加载器去加载，而没有机会去加载咱们自定义的Object类。
 *
 * 3、不同的类加载器可以为相同名称（binary name）的类创建额外的命名空间，相同名称的类可以并存在java虚拟机中，
 * 只需要用不同的类加载器来来加载他们既可。不同的类加载器所加载的类之间是不兼容的，
 * 这就相当于在Java虚拟机的内部创建了一个又一个相互隔离的Java类空间，这类技术在很多框架中都得到了实际应用。
 *
 *
 *
 */
public class MyTest21 {

    public static void main(String[] args) throws Exception {

        MyTest16 loader1 = new MyTest16("loader1");
        MyTest16 loader2 = new MyTest16("loader2");

        loader1.setPath("/Users/zyh/Documents/JavaWorkSpace/jvm_lecture/bin/main/");
        loader2.setPath("/Users/zyh/Documents/JavaWorkSpace/jvm_lecture/bin/main/");

        Class<?> clazz1 = loader1.loadClass("com.shengsiyuan.jvm.classloader.MyPerson");
        System.out.println("---1---");
        Class<?> clazz2 = loader2.loadClass("com.shengsiyuan.jvm.classloader.MyPerson");
        System.out.println("---2---");
        //然后将MyPerson.class从咱们的工程当中删除掉(操作)
        //返回false
        //如果两个加载器之间没有直接或间接的父子关系，那么它们各自加载的类相互不可见。【符合咱目前的场景】
        System.out.println(clazz1 == clazz2);
        Object object1 = clazz1.newInstance();
        Object object2 = clazz2.newInstance();

        Method method = clazz1.getMethod("setMyPerson", Object.class);
        //然后将MyPerson.class从咱们的工程当中删除掉(操作)
        /**
         * Exception in thread "main" java.lang.reflect.InvocationTargetException
         * 	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
         * 	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
         * 	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
         * 	at java.lang.reflect.Method.invoke(Method.java:498)
         * 	at com.shengsiyuan.jvm.classloader.MyTest21.main(MyTest21.java:29)
         * Caused by: java.lang.ClassCastException: com.shengsiyuan.jvm.classloader.MyPerson cannot be cast to com.shengsiyuan.jvm.classloader.MyPerson
         * 	at com.shengsiyuan.jvm.classloader.MyPerson.setMyPerson(MyPerson.java:12)
         * 	... 5 more
         */
        method.invoke(object1, object2);//如果两个加载器之间没有直接或间接的父子关系，那么它们各自加载的类相互不可见。【符合咱目前的场景】
        //clazz1和clazz2在不同的命名空间里面而又不是父子关系所以是相互不可见的

    }
}
