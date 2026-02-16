package com.codewithcenna.Generics.Generic_Method_7;

//this is a class that have some utility method
//there is convention that utility methods be static, to can use without obj

public class Utils {
    public static int max (int first, int second){
        return (first > second) ? first : second;
    }

    public static <T extends Comparable<T>> T gmax (T first, T second){   // <T> comes before return type like
                                                                          // <K,V> void  print (K key, V value)
                                                                          //we create genric method that used a generic interface
                                                                          //we get a type from outside and pass it to
                                                                          //our method and comparable interface

        return ((first.compareTo(second)) < 0) ? second : first;    //logical operator acts only on numbers and carechters
                                                                    //so we cant compare some object like pre method(we need value)
                                                                    //we can use comparable interface!
                                                                    //first and second have compareTo method
                                                                    //first and second are TR type
                                                                    //because of constraint, we know T is a comparable object
    }
}
