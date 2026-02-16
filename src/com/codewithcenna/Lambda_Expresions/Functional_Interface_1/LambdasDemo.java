package com.codewithcenna.Lambda_Expresions.Functional_Interface_1;

public class LambdasDemo {
    public static void show(){
        greet (new ConsolePrinter());
    }

    public static void greet (Printer printer){
        System.out.println("Hello World");
    }
}
