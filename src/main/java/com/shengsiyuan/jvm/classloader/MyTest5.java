package com.shengsiyuan.jvm.classloader;

/**
 * 总结：
 * 当一个接口初始化时并不要求其父接口完成了初始化
 * 只有在真正用到父接口的时候（如引用接口中定义的常量时），才会初始化。
 * 而类不是这样的，原因就是借口中的变量本来就是final的。
 */
public class MyTest5 {

    public static void main(String[] args) {
        System.out.println(MyChild5.b);
    }
}

interface MyParent5 {
    public static final int a = 5;
}

interface MyChild5 extends MyParent5 {
    public static final int b = 6;
}