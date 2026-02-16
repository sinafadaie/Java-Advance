package com.codewithcenna.Lambda_Expresions.Summary_16;
import com.codewithcenna.Lambda_Expresions.Functional_Interface_1.Printer;
import com.codewithcenna.Streams.Sorting_6.Movie;

import java.util.Comparator;

import static com.codewithcenna.Lambda_Expresions.Functional_Interface_1.LambdasDemo.greet;


//in past we said that lambda act like interface instance
//but it better to say, we can create object from interface with help of that lambda
//where ever we saw a functional interface **type** (parameter type,return type,variable type)
//we can use that type by implement abstract method by lambda
//it could be in static method!
//-------
// when you create object
//you cant access to class level method from object
//so when you create interface object with lambda
//you cant use static method of that interface,
//for static method you should use the interface directly


public class LambdaDemo {
    public static void show(){

        //variable
        Printer p = (msg) -> System.out.println(msg);   //p is now a Printer object and we save the address

        //parameter
        greet(message -> System.out.println(message));  //greet get Printer type
        Comparator.comparing((Movie m)->m.getLikes());        //implement apply() by lambda fo function
                                                              //comparing is static method of Comparator that get a function
                                                              //lambda implement apply() for function interface!

        //return
        /*default Consumer<T> andThen(Consumer<? super T> after) {
            Objects.requireNonNull(after);
            return (T t) -> { accept(t); after.accept(t); };  //its not return lambda,its return a consumer object!
        }
        */

    }

}
