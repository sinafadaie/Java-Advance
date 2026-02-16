package com.codewithcenna.Lambda_Expresions.Binary_Interface_14;
import java.util.function.BinaryOperator;
import java.util.function.Function;
//interface BinaryOperator<T> extends BiFunction<T, T, T>
//get two argument and return something
//but because they are same type, it just get T
//-----
//we said in first of section, we have so many functional interface
// in package java.util.function
// and all of them categorized in Consumer,Supplier,Function and Predicate
//-----
//Interface BinaryOperator<T>
//<T> ,means we just declare a type once(two parameters are same, return type is based on parameter)
//BinaryOperator is special of Function
//its extends to BiFunction interface(get tow argument)
//normal BiFunction was BiFunction<T,U,R>, it is specialized it (BiFunction<T,T,T>)
//BinaryOperator get two operand and return a single result lik x=1+2
//-----
//it has primitive specialization like IntBinaryOperator
//get tow integer parameter, and return an integer

public class BinaryDemo {

    public static void shows(){
        BinaryOperator <Integer> add = (a,b)-> {return a+b;};
        System.out.println(add.apply(2,3));     //because apply get Integer object
                                                      //and we passed to it a primitive, compiler will auto boxing
                                                      //so if we want to dont pay cost of boxing, we should primitive specialization(IntBinaryOperator)

        Function<Integer,Integer> square = (a)->{return a*a;};   //because we just have one parameter
                                                                        //we use function, we cant use the binaryOperation
                                                                        //in function we should specify both parameter and return type
                                                                        //Function<Integer,Integer>

        System.out.println(add.andThen(square).apply(2,3));       //because binaryOperator is a kind of function
                                                                        //it has apply() method
                                                                        //and also we can use andThen to composite to another **function**

    }
}
