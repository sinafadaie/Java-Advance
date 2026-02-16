package com.codewithcenna.Collections.Why_Need_Iterable_2;

//if we want to iterate over our list
//if we use for each loop
//compiler say: for each not applicable to type T
//you shou define it first

public class Main {
    public static void main(){
        var list = new GenericList<String>(5);
        list.add("sina");

        //for(var item : list){
        //}

        for (var item : list.items){    //we solve it by make items field public in Generic class
            System.out.println(item);   //it is very bad solution
                                        //we have broken oop concepts
                                        //if we change implementation of generic list
                                        //so many error occur
        }

    }
}
