package com.codewithcenna.Exception.What_Is_Exception_1;

//exception is an object that contain information about an error (when error occurred,this object created)
//now this object is instance of NullPointerException class
//NullPointerException is class that declare in java.lang package
//-----------------------
//the below information, that show error line
//who called the broken method
//what the exception kind
//is called stack trace
//its shows the methods that have been called in the **reverse** order(1.sayHello 2.show 3.main)

public class Main {
    public static void main(){
        ExceptionDemo.show();
    }
}
