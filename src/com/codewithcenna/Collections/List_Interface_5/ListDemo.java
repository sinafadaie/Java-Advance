package com.codewithcenna.Collections.List_Interface_5;

//the list interface represents an ordered collection(also called a sequence)
//list is index oriented(access element by index)
//collection was not index oriented (in collection--->remove("a"))
//if you care about index of element in a collection,you should use lists
//List interface extend to collection interface(so we have pre methods)

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListDemo {
    public static void show(){
        List<String> list = new ArrayList<>();
        Collections.addAll(list,"a","b","c");
        list.add("d");

        list.add(0,"!");    //we have overloaded add method
                                          //to be able adding element to specific index
        System.out.println(list );
        System.out.println(list.get(0));  //get element by index

        list.set(0,"!!");                 //replace specific index
        System.out.println(list);

        list.remove(0);             //remove a index
        System.out.println(list);

        System.out.println(list.indexOf("a"));   //show the index(-1 if there is not any)

        System.out.println(list.lastIndexOf("a"));

        var subList = list.subList(0,2);         //from index is inclusive
                                                 //to index is exclusive
                                                 //this method return new list(current list does not change)
        System.out.println(list);
        System.out.println(subList);
    }
}