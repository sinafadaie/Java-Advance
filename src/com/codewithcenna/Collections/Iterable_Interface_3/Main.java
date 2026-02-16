package com.codewithcenna.Collections.Iterable_Interface_3;
//the iterable interface represents an object that is iterable
//that means we can iterate it without knowing anything about its implementation detail
//so if our generic list be iterable,when we change our array structure, our code will be stable
//-----------
//we write for each loop and open byte code
//we see that it has haseNext and Next() method
//so for each loop is just syntactical sugar over iterator object
//compiler convert for each loop to iterator object
//its interesting, after we extend our generic list to Iterable, we can use foreach loop!
public class Main {
    public static void main(){
        var list = new GenericList<String>(5);
        list.add("sina");
        list.add("Leila");

        var iterator = list.iterator(); //with this,we can iterate on our list(without knowing the implementation)

        while (iterator.hasNext()){
            var current = iterator.next();
            System.out.println(current);
        }

        for (var item: list){           //after we extend our generic list to Iterable, we can use foreach loop!
            System.out.println(item);
        }
    }
}
