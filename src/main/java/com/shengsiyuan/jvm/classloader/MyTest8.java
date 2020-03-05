package com.shengsiyuan.jvm.classloader;

import java.util.Random;

//FinalTest.x目前是个编译期常量，它会在编译期间将其放到常量池，并不会导到FinalTest的主动使用，
class FinalTest {
    public static final int X = 3;

    static {
        System.out.println("FinalTest static block ");
    }
}

class FinalTest2 {
    public static  int X = 3;

    static {
        System.out.println("FinalTest2 static block ");
    }
}

class FinalTest3 {
    public static  final  int X = new Random().nextInt(3);

    static {
        System.out.println("FinalTest3 static block ");
    }
}


public class MyTest8 {

    public static void main(String[] args) {
        System.out.println(FinalTest.X);
        System.out.println("-------------");

        System.out.println(FinalTest2.X);

        System.out.println("-------------");

        System.out.println(FinalTest3.X);
    }

}

/*
Compiled from "MyTest8.java"
public class com.shengsiyuan.jvm.classloader.MyTest8 {
  public com.shengsiyuan.jvm.classloader.MyTest8();
    Code:
       0: aload_0
       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
       4: return

  public static void main(java.lang.String[]);
    Code:
       0: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
       3: iconst_3 -------
       4: invokevirtual #4                  // Method java/io/PrintStream.println:(I)V
       7: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
      10: ldc           #5                  // String -------------
      12: invokevirtual #6                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
      15: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
      18: getstatic     #7                  // Field com/shengsiyuan/jvm/classloader/FinalTest2.X:I
      21: invokevirtual #4                  // Method java/io/PrintStream.println:(I)V
      24: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
      27: ldc           #5                  // String -------------
      29: invokevirtual #6                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
      32: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
      35: getstatic     #8                  // Field com/shengsiyuan/jvm/classloader/FinalTest3.X:I
      38: invokevirtual #4                  // Method java/io/PrintStream.println:(I)V
      41: return
}
 */
