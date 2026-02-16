package com.codewithcenna.Exception.What_Is_Exception_1;

//when a exception occurs in a method
//that method threw an exception, just like threw a ball
//java run time hope to there is exception handler to catch this ball
//at first look at first method (sayHello)
//if there is not any com up, look at show method
//until reach main method
//if there is not exception handler in main method too, it will terminate the program

public class ExceptionDemo {
    public static void show(){
        sayHello(null);
    }

    public static void sayHello(String name){
        System.out.println(name.toUpperCase());
    }
}
