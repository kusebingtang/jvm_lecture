package com.shengsiyuan.jvm.classloader;
//        类的加载、连接与初始化
//        加载：查找并加载类的二进制数据
//        连接：
//        验证：确保被加载类的正确性。
//        准备：为类的静态变量分配内存，并将其初始化为默认值。
//        解析：把类中的符号引用装换为直接引用。
//        初始化：为类的静态变量赋予正确的初始值

class CL{
    static {
        System.out.println("Class CL");
    }
}
/*
调用classLoader类的loadClass方法加载一个类，并不是对类的主动使用，不会导致类的初始化
 */
public class MyTest12 {
    public static void main(String[] args) throws Exception {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        Class<?> cl = classLoader.loadClass("com.shengsiyuan.jvm.classloader.CL");//不会触发类的初始化
        System.out.println(cl);
        System.out.println("-------------------------");
        cl = Class.forName("com.shengsiyuan.jvm.classloader.CL");//使用了反射，这属于类初始化时机的反射时机。会触发类的初始化。
        System.out.println(cl);
    }
}
/**
 * 主动使用（七种）
 * 创建类的实例。
 * 访问某个类或者接口的静态变量，或者对该静态变量赋值。
 * 调用类的静态方法。
 * 反射 （如Class.forName(“com.test.Test”)）
 * 初始化一个类的子类
 * Jav啊虚拟机启动时被标明为启动类的类(Java Test)
 * JDK1.7开始提供的动态 语言支持：
 * Java.lang.invoke.MethodHandle实例的解析结果REF_getStattic REF_putStatic REF_invokeStatic句柄对应的类如果没有初始化，则初始化(了解)
 * 除了以上七中情况，其他使用Java类的方式都被看做是对类的被动使用，都不会导致类的初始化(指的是加载，连接，初始化这个步骤的初始化)
 * ————————————————
 *
*/
