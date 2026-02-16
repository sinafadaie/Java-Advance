package com.codewithcenna.Generics.Multiple_Type_Parameters_8;

public class Utils {
    public static <T extends Comparable<T>> T gmax (T first, T second){

        return ((first.compareTo(second)) < 0) ? second : first;
    }

    public static  <K,V> void  print (K key, V value){
        System.out.println(key + ":" + value);
    }
}
