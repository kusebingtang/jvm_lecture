package com.shengsiyuan.jvm.classloader;

import com.sun.crypto.provider.AESKeyGenerator;

/**
 * @author JiangBin
 * @create 2020-03-29 16:45
 */
public class MyTest19 {

    public static void main(String[] args) {
        AESKeyGenerator aesKeyGenerator = new AESKeyGenerator();
        System.out.println(aesKeyGenerator.getClass().getClassLoader());
        System.out.println(MyTest19.class.getClassLoader());
    }
}
