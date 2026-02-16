package com.codewithcenna.Lambda_Expresions.Predicate_Interface_12;
import java.util.function.Predicate;

//interface Predicate<T>
//get a parameter,and return boolean
//because the return type is clear, it just gets T for the parameter
//--------
//we use this interface to filter data
//it is a functional interface ( test(T t) method as abstract method)
//get a parameter, always return a boolean (so don't need to specify type of return)
//---------
//BiPredicate<T,U> get tow argument, and return boolean
//and has primitive specializations like
//IntPredicate,...
public class PredicateDemo {
    public static void shows(){
         //check a word length

        Predicate <String> wordLenghthCheck = word-> {return word.length()>5;}; //just need specify String for parameter

        System.out.println(wordLenghthCheck.test("sina"));


    }
}
