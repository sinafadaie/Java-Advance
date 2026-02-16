package com.codewithcenna.Lambda_Expresions.UnaryOperator_15;

import java.util.function.UnaryOperator;

//Interface UnaryOperation<T>
//we dont specify return type(its clear based on parameter type(return T))
//its exactly like function
//its extends to Function<T,T>
public class UnaryDemo {
    public  static void shows(){
        UnaryOperator <Integer>  square = a->{return a*a;};
        UnaryOperator <Integer>  increment = a->{return a+1;};

        var x =increment.andThen(square).apply(1);
        System.out.println(x);
    }
}
