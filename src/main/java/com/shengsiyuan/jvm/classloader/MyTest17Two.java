package com.shengsiyuan.jvm.classloader;

/**
 * @author JiangBin
 * @create 2020-03-29 16:01
 *
 * 1、由父加载器所加载的类是看不到子加载器所加载的类的，
 * 2、由子加载器所加载的类是能看到父加载器所加载的类的
 */
public class MyTest17Two {

    public static void main(String[] args) throws Exception {

        MyTest16 loader1 = new MyTest16("loader1");
        loader1.setPath("/Users/zyh/Documents/JavaWorkSpace/jvm_lecture/bin/main/");
        Class<?> mySampleClass = loader1.loadClass("com.shengsiyuan.jvm.classloader.MySample");
        System.out.println("mySampleClass hashCode:" + mySampleClass.hashCode());
        Object object = mySampleClass.newInstance();


    }

}
