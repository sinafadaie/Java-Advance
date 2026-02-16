package com.codewithcenna.Lambda_Expresions.Supplier_interface_9;

//interface Supplier<T>
//just return T type
//-----
//supplier is exactly opposite of consumer
//means it does not consume anything!(its method hasnt any parameter)
//but it return something(supply something)
//this interface just have one abstract method (get) so it is a functional interface
//so we can represent it by lambda expression (get method has no any parameter so the lambda is the same)
//------
//like consumer it has **primitives variant** like double,int,...
//interface IntSupplier(the return type is clear so have not any T)
//use this prevent autoboxing and unboxing cost

import java.util.function.Supplier;

public class SupplierDemo {
    public static void show(){
        Supplier <Double> getRandom = ()->{return Math.random();};      //getRandom  is now just a lambda
                                                                        //witch type is supplier object
                                                                        //return were removed in method reference mood(target method will return itself!)

        System.out.println(getRandom.get());                            //Math.random() is called lazy evaluation
                                                                        //this means it not execute where we write it
    }                                                                   //we just put it there in a lambda
                                                                        //if we call it like line 20,it will execute

}

