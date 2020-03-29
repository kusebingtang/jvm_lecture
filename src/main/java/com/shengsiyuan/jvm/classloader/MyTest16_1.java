package com.shengsiyuan.jvm.classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class MyTest16_1 extends ClassLoader {
    private String classLoaderName;
    private final String fileExtension = ".class";//要加载的字节码文件的扩展名

    public MyTest16_1(String classLoaderName) {
        super();//将系统类加载器当作该类加载器的父加载器
        this.classLoaderName = classLoaderName;
    }

    public MyTest16_1(ClassLoader parent, String classLoaderName) {
        super(parent);//显示指定该类加载器的父加载器
        this.classLoaderName = classLoaderName;
    }

    @Override
    public String toString() {
        return "[" + classLoaderName + "]";
    }

    @Override
    protected Class<?> findClass(String className) throws ClassNotFoundException {
        byte[] data = this.loadClassData(className);
        return this.defineClass(className, data, 0, data.length);
    }

    private byte[] loadClassData(String name) {
        InputStream is = null;
        byte[] data = null;
        ByteArrayOutputStream baos = null;

        try {
            this.classLoaderName = this.classLoaderName.replace(".", "/");
            is = new FileInputStream(new File(name + this.fileExtension));
            baos = new ByteArrayOutputStream();

            int ch = 0;

            while (-1 != (ch = is.read())) {
                baos.write(ch);
            }

            data = baos.toByteArray();

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                is.close();
                baos.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }


        return data;
    }

    private static void test(ClassLoader classLoader) throws Exception {
        Class<?> clazz = classLoader.loadClass("com.shengsiyuan.jvm.classloader.MyTest1");
        Object object = clazz.newInstance();

        System.out.println(object);
    }

    public static void main(String[] args) throws Exception {
        MyTest16_1 myTest16 = new MyTest16_1("loader1");
        test(myTest16);
    }
}