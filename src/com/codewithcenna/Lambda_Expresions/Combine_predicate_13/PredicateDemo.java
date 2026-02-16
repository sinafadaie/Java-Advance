package com.codewithcenna.Lambda_Expresions.Combine_predicate_13;

//we have and,or,negate default method on predicate
//they are act like logical operator
//so we can use them to create a composite predicate

import java.util.function.Predicate;

public class PredicateDemo {
    public static void shows(){
        Predicate <String> hasLeftBrace = str-> {return str.startsWith("{");};
        Predicate <String> hasRightBrace = str-> str.endsWith("}");

        Predicate <String> fullBrace = hasLeftBrace.and(hasRightBrace);
        System.out.println(fullBrace.test("{Sina}"));

        Predicate <String> semiBrace = hasLeftBrace.or(hasRightBrace);
        System.out.println(semiBrace.test("{sina"));

        Predicate <String> emptyBrace = fullBrace.negate();  //! operator
        System.out.println(emptyBrace.test("Sina"));      //ite return a new predicate with opposite value

    }
}
