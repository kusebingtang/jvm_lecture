package com.shengsiyuan.jvm.classloader;

public class MyTest7 {


    public static void main(String[] args) throws ClassNotFoundException {

        /**
         *
         *      * Returns the class loader for the class.  Some implementations may use
         *      * null to represent the bootstrap class loader. This method will return
         *      * null in such implementations if this class was loaded by the bootstrap
         *      * class loader.
         *      *
         */
        Class<?> clazz = Class.forName("java.lang.String");
        System.out.println(clazz.getClassLoader()); // null //由根加载器 bootstrap class loader ，输出为null


        Class<?> clazz2 = Class.forName("com.shengsiyuan.jvm.classloader.C");
        System.out.println(clazz2.getClassLoader());//jdk.internal.loader.ClassLoaders$AppClassLoader@4459eb14
    }
}

class  C {

}
