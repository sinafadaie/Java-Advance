package com.codewithcenna.Lambda_Expresions.Method_Reference_5;

//method reference is just created for lambdas
//when we just call a single method in lambda(don't doing another thing)
//we can just pass the address of that method (reference to that method)
//in this situation, because we don't call anything(just passing address)
//we don't use ()
//in this case lambda is just transfer address of target method
//--------------------
//the referenced method, has to have same parameter as
//our functional interface method

import com.codewithcenna.Lambda_Expresions.Functional_Interface_1.Printer;

public class LambdasDemo {                      //constructor is kind of method
    public LambdasDemo(String massage) {        //we can reference to it!
        System.out.println(massage);
    }

    public static void show(){

        Printer printer = message -> {   //yellow lamp does not suggest
            System.out.println(message);       //replace lambda with method reference
            System.out.println(message+"!");   //because in implementing, we are doing too much thing
                                               //method reference is just for the time we are calling another method
        };

        printer.print("common");            //printer is lambda, act like instance of printer interface
                                            //so it has print method inside
                                            //but in greet we just want to pass a printer object(do not use print method)
        //----------
        printer = message -> System.out.println(message);    //we just use lambda to pass a parameter
                                                                   //to existing method, so we can use method reference
                                                                   //here we just use println method from System.out object
                                                                   //we have yellow lamp here,its offer to replace it with method reference

        printer = System.out::println;      //we create method reference with yellow lamp(alt+enter)
                                            //replace lambda with method reference
                                            //we can use println because its get just string(like our interface method)

        printer = message -> anotherMethod(message);        //we just use lambda to pass a parameter
                                                                  //to another method, so we can use method reference
        printer = LambdasDemo::anotherMethod;

        printer.print("Im calling anotherMethod");
        greet(printer);

        //----------
        //our target method can be a constructor

        printer = message -> new LambdasDemo("from constructor");
        printer =  LambdasDemo::new;         //new means use constructor as our method
                                             //the constructor has compatible parameter


    }

    public static void greet (Printer printer){
        System.out.println("Hello World");
        printer.print("it interesting");     //its new
                                             //because we pass the lambda instead printer object
                                             //we have access to its method(where we implement in lambda)
    }

    public static void anotherMethod(String massage){   //this methods parameter have to same as the
        System.out.println(massage);                    //interface method we were implementing in lambda
        System.out.println("Im do more");
    }
}
