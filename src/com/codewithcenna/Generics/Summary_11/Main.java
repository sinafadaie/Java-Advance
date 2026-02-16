package com.codewithcenna.Generics.Summary_11;

public class Main {
    public static void main(){
        var list = new GenericList<String>(5);   //OK you can add anything to an object array
        list.add("sina");
        list.add("Leila");

        var list2 = new GenericList<Integer>(4); //OK you can add anything to an object array
        list2.add(4);

        //var x=list2.items[0];                      //its get error, jvm say what the fuck, i see the array it's not T type
        System.out.println(list.get(0));             //but if we isolate our list in generic class
                                                     //we can access to elements by method
                                                     //because they are in same place, due to erasure they are compatible
    }
}
