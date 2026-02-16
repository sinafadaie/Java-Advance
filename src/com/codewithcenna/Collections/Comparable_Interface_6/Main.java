package com.codewithcenna.Collections.Comparable_Interface_6;

//sort from Collections just get a list object(as argument)
//Collections is a utility class that contains static helper methods for working with collections
//so many methods exist there just for specify collection(like sort just for list)
//----------
//a lot of sorting algorithm using comparing objects
//they determine witch object should come first, witch one should come next

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(){
        List <Customer> customers = new ArrayList<>();

        customers.add(new Customer("Sina"));
        customers.add(new Customer("Leila"));
        customers.add(new Customer("Sepehr"));
        Collections.sort(customers);        //its just have error at first
                                            //no instance of type variable T exits-->says customer class does not implement comparable interface
                                            //sort method use comparable methods(so we should pass a comparable list)

        System.out.println(customers);      //we got just a sorted list

        //-------------------------------
        //remember, we just can compare number and character with logical operators
        //Strings are objects, they are not character

        //System.out.println("Sina">"Leila");       got error
        System.out.println('S'>'L');
        //System.out.println("S">"L");              even this got error
    }
}
