package com.shengsiyuan.jvm.classloader;

/**
 * @author JiangBin
 * @create 2020-03-29 16:37
 */
public class MyTest18One {
    public static void main(String[] args) throws Exception {
        MyTest16 loader1 = new MyTest16("loader1");
        loader1.setPath("/Users/zyh/Documents/JavaWorkSpace/jvm_lecture/bin/main/");
        Class<?> clazz = loader1.loadClass("com.shengsiyuan.jvm.classloader.MyTest1");
        System.out.println("class : " + clazz.hashCode());
        System.out.println("class loader :" + clazz.getClassLoader());
    }
}
