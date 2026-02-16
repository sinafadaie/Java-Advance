package com.codewithcenna.Lambda_Expresions.Composing_Functions_11;

//its like chain consumer
//stick functions together with another method
//so we can build complex functions from simple functions
//-------
//andThen method return lambda in both consumer and function interface
//so we can store it in a variable that act like consumer/function obj
//(this obj hase apply,andThen method)
//-------
//compose is similar to andThen
//its return a lambda too
//but chained these function in the reverse order

import java.util.Objects;
import java.util.function.Function;

public class ComposeDemo {
    public static void show(){
        // "key:value"
        //first: "key=value"
        //second: "{key=value}"

        Function<String,String> replaceColon = str ->{return str.replace(":","=");};
        Function<String,String> addBraces = str ->{return "{" + str + "}" ;};

        replaceColon.apply("key:value");
        addBraces.apply("key:value");

        Function<String, String> composedFunction = replaceColon
                                                    .andThen(addBraces);    //its all return a function that stored in a variable
                                                                            //its declarative programing
                                                                            //just said at first replace colon and then add braces(what to be done)
                                                                            //in convention,each statement in a new line
        /*
        default <V> Function<T, V> andThen(Function<? super R, ? extends V> after) {
            Objects.requireNonNull(after);
            return (T t) -> after.apply(apply(t));
        }
         */
        //-----let see
        //default <V> Function<T, V> andThen(Function<? super R, ? extends V> after)
        //the andThen method is a Function<T, V>(get T type, return V type)
        //but the T type as parameter is unclear now
        //we know it is a Function<? super R, ? extends V>
        //witch means its has a capture class above R as an input(when define R in runtime,create capture class above R)
        //and has a capture class under V as return
        //in this way they restrict andThen method
        //it just executes on same type (it returns V,and just get V(the argument fn return V))

        System.out.println(composedFunction.apply("key:value"));

        Function <String,String> composedFunctionReverse = replaceColon     //first addBrace, then replace colon
                                                           .compose(addBraces);

        System.out.println(composedFunctionReverse.apply("key:value"));

        //control+click
        /*
        default <V> Function<V, R> compose(Function<? super V, ? extends T> before) {
            Objects.requireNonNull(before);
            return (V v) -> apply(before.apply(v));
          }
         */

    }
}
