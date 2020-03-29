package com.shengsiyuan.jvm.classloader;

/**
 * @author JiangBin
 * @create 2020-03-29 16:37
 */
public class MyTest18 {
    public static void main(String[] args) {
        System.out.println(System.getProperty("sun.boot.class.path"));
        System.out.println("-------------------------------------------");
        System.out.println(System.getProperty("java.ext.dirs"));
        System.out.println("-------------------------------------------");
        System.out.println(System.getProperty("java.class.path"));
    }
}
