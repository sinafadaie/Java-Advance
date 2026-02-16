package com.codewithcenna.Lambda_Expresions.Function_Interface_10;

import java.util.function.Function;
//interface Function<T, R>
//T for parameter,R for return
//-------
//consumer get argument ,return nothing
//supplier has no argument, but return something
//function get argument,return something
//its a functional interface with an abstract method called **apply**
//--------
//we have some specialization for this interface
//like BiFunction<T,U,R>
//(T:argument,U:argument,R:result) that get tow parameter
//primitive specializations fall into three categories base on generic type
//for example for integer we have:
//IntFunction<R>        return type is parameterized(generic),argument is specialized
//ToIntFunction<T>      return type is specialized,argument is generic
//IntToLongFunction     both are specialized(get int,return long)

public class FunctionDemo {
    public static void show(){

        Function<String,Integer> map = str-> {return str.length();};      //our lambda just have one parameter(String)
                                                                                //and return type is integer
                                                                                //compiler know from function that our lambda return
                                                                                //so it is gray

        System.out.println(map.apply("sky"));

    }
}
