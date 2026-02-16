package com.codewithcenna.Lambda_Expresions.Lambdas_Expretion_3;

//we cant create instance from interface in java
//but from java 8 we have lambda, it's create an instance of interface immediately!
//we can just use lambda on **functional interface**
//so we implement interface method with lambda, and it has type of interface
//we can use it instead of anonymous inner function(its cleaner)
//----------important:
//When you use a lambda expression:
//Java does the following behind the scenes:
//It creates an anonymous class
//That class implements the Printer interface
//It creates an object from that class
//The reference to that object is stored in the printer variable
//So even though you didn’t explicitly write a class or use **new**,
//an object does exist, and printer points to it.(we create object without writing new)
//so we really have an object, and save address of that object in variable like printer

public class Main {
    public static void main(){
        LambdasDemo.show();
    }
}
