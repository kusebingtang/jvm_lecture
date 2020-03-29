package com.shengsiyuan.jvm.classloader;

import java.lang.reflect.Method;

/**
 * @author JiangBin
 * @create 2020-03-29 16:47
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
