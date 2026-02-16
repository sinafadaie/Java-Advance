package com.codewithcenna.Lambda_Expresions.Variable_Capture_4;

//lambda has access to fields and variable in enclose method and enclose class
//capture their variable (lambdas act like a function in them)
//--------
//there is a important different between lambdas and anonymouse classes
//if we write anonymouse classes, when we use **this**, it refers to anonymouse classes object
//but lambda is not a class, so it refer to above class object
//--------
//anonymouse classes are classes
//so they can have fields
//but lambdas don't have (lambdas acts like anonymous functions)
//--------summary:
//in Anonymous Class a new object is created every time(separate class file is usually generated)
//but in lambda  jvm reuse the same instance
//Create it lazily (only when needed)
//Not generate a separate class at all, using invokedynamic
//so lambda expressions are usually lighter and more efficient than anonymous classes.

import com.codewithcenna.Lambda_Expresions.Functional_Interface_1.Printer;

public class LambdasDemo {
    static  String y="!";   //make it static to access in static method
    String p="!";

    public static void show(){
        var x="-";          // - called hyphen
        Printer printer = message -> System.out.println(x+message+y);        //x for show,y for LambdasDemo
        printer.print("common");        //use lambda like an interface instance
    }

    public  void instanceShow(){
        Printer printer = message -> System.out.println(message+this.y);     //we are in LambdasDemo class,this refers to current LambdasDemo obj
        printer.print("common");
    }

    public static void greet (Printer printer){
        System.out.println("Hello World");
    }
}
