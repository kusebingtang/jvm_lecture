package com.shengsiyuan.jvm.classloader;

/**
 * 加载：查找并加载类的二进制数据【这个不说了，就是把Singleton的二进制文件放入内存】
 * 连接：
 * 验证：确保被加载类的正确性。【这个也不说了】
 * 准备：为类的静态变量分配内存，并将其初始化为默认值。【此时Singleton的counter1赋予初始化值为0，singleton赋值为null，counter2赋值为0】
 * 解析：把类中的符号引用装换为直接引用。【不说了】
 * 初始化：为类的静态变量赋予正确的初始值。【程序初始化顺序是从上而下，首先是counter1程序员没有对它进行赋值，还是准备赋予的值为0，接着是singleton赋值为new Singleton()，
 * 此时会调用构造器，构造器调用完毕counter1=1，counter2=1，然后程序继续初始化，到了 public static int counter2=0;时，静态变量counter2重新赋值为0】
 */
public class MyTest6 {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        System.out.println(Singleton.counter1);
        System.out.println(Singleton.counter2);
    }
}

class Singleton {
    public static int counter1;

    private static Singleton singleton = new Singleton();

    private Singleton() {
        counter1++;
        counter2++;
    }
    public static int counter2 = 0;

    public static Singleton getInstance() {
        return singleton;
    }
}