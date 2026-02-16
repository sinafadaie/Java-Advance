package com.codewithcenna.Lambda_Expresions.Lambdas_Expretion_3;

//we don't write name of method we are implementing
//because lambda just use on functional interface(we have just one method)
//------------------
// -> called lambda expression
//and says we are passing these parameters to this implementing method

import com.codewithcenna.Lambda_Expresions.Functional_Interface_1.Printer;

public class LambdasDemo {
    public static void show(){

        //Printer printer = new Printer();           we cant create a normal instance from interface,
                                                    //but we can use lambda instead

        Printer printer = (String message) -> {     //we can remove type of parameter(String)
            System.out.println(message);            //the compiler know it from the interface
        };                                          //and also if our method just have one parameter, we can remove parentheses
                                                    //if you have multiple or none parameter, we need them
                                                    //we need ; at the end!

        Printer printer2 = message -> System.out.println(message);

        printer.print("common");                    //printer is lambda, act like instance of printer interface
                                                    //so it has print method inside
                                                    //but in greet we just want to pass a printer object(do not use print method)

        greet(printer);                                         //greet just get Printer type
        greet(message -> System.out.println(message));   //we can use lambda directly
    }                                                          //greet print hello world
                                                               //it just gets prints object redundantly

    public static void greet (Printer printer){
        System.out.println("Hello World");
    }
}
