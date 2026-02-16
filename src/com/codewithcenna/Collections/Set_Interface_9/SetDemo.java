package com.codewithcenna.Collections.Set_Interface_9;

import java.util.*;

public class SetDemo {
    public static void show(){
        Set<String> set = new HashSet<>();
        set.add("Sina");
        set.add("Leila");
        set.add("Sepeher");
        set.add("Sina");

        System.out.println(set);    //the order is not based on the order of adding items
                                    //the Sina is stored just once

        Collection<String> doubleCollection = new ArrayList<>();
        Collections.addAll(doubleCollection,"a","b","c","c");

        Set<String> uniqueCollection = new HashSet<>(doubleCollection); //HashSet have three time overloaded constructor
                                                                        //one of them get a collection of unknown extended string(any type that extended to string)
                                                                        //so we can pass a collection of string

        System.out.println(uniqueCollection);       //so just we create a unique collection with single row of code!
                                                    //it's a god technic


        //-----------------new way to create list
         var list1 = Arrays.asList("a","b","c");   //Arrays class like collections class
                                                   //these are utility class to general use
                                                   // ... in argument called var args witch represent a variable number of argument(can pass many argument)

         var list2 = Arrays.asList("b","c","d");
        //-----------------operations
        Set <String> set1 = new HashSet<>(list1);
        Set <String> set2 = new HashSet<>(list2);

        set1.addAll(set2);              //union operator(set1 will change)
        System.out.println(set1);       //[a, b, c, d]

        set1.retainAll(set2);           //intersection operator(set1 will change)
        System.out.println(set1);       //like inner join

        set1.removeAll(set2);           //difference operator
        System.out.println(set1);       //like minus in sql
    }
}
