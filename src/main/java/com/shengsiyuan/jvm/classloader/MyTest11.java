package com.shengsiyuan.jvm.classloader;

class Parent3 {
    static int a = 3;

    static {
        System.out.println("Parent3 static block");
    }

    static void doSomething() {
        System.out.println("doSomething...");
    }
}

class Child3 extends Parent3 {
    static {
        System.out.println("Child3 static block");
    }
}

//如果用子类去访问父类的静态变量或静态方法，表示的是对于父类的主动使用，而非表示对子类的主动使用。
public class MyTest11 {
    public static void main(String[] args) {
        System.out.println(Child3.a);//由于Child3.a调用的是它父类Parent3里面的变量，所以也就是对Parent3的主动使用
        System.out.println("-------------");
        Child3.doSomething();//通过Child3去调用它父类的doSomething()，同样也不会导至Child3的初始化，而只会导致Parent3进行初始化，
        // 但是由于它之前已经被初始化了  sout(doSomething...)
    }
}
