package com.codewithcenna.Lambda_Expresions.Anonymous_Inner_Class_2;

import com.codewithcenna.Lambda_Expresions.Functional_Interface_1.Printer;

public class LambdasDemo {
    public static void show(){
        greet(new Printer() {                       //we just write "new Printer"
            @Override                               //but intellij due to know, we cant create instant from an interface
            public void print(String message) {     //it writes an anonymous class automatically
                System.out.println(message);        //it is anonymous because it hasn't name
            }                                       //it is inner because, its define inside a method
        });                                         //if we use "this", it refers to current anonymous class obj
    }

    public static void greet (Printer printer){
        System.out.println("Hello World");
    }
}
