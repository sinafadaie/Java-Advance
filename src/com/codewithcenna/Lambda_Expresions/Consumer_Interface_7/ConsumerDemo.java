package com.codewithcenna.Lambda_Expresions.Consumer_Interface_7;
import com.codewithcenna.Collections.Iterable_Interface_3.GenericList;
//interface Consumer<T>
//it just get a parameter,and return nothing
//--------
//consumer interface represent an operation that takes a single argument
//and does not return a value
//a lot of method expect a consumer object in java(like forEach method)
//--------
//consumer interface has some variation
//interface BiConsumer<T, U> (get tow argument)
//interface IntConsumer (we know the type, so don't have any T)
//(although consumer is generic,it's good to use this when work with integer to dont pay the cost of auto boxing)
//LongConsumer,...
//--------
//there are two-way to iterate over a list
//for each loop it is Imperative programing
//it means implementing logics using instruction
//it's a programing paradigms
//we have so many programing paradigms(functional,oop,driven,...)
//--------
//in bottom we use declarative programing
//use a method that get a consumer
//we specify what needs to be done instead if how be done


public class ConsumerDemo {

    public static  void show(){
        GenericList <String> list = new GenericList<>(3);
        list.add("a");
        list.add("b");
        list.add("c");

        //Imperative programing:
        //we said how print items in list
        for (var item : list ){
            System.out.println(item);
        }

        //declarative programing
        //we just said prin items in list:

        list.forEach( (String item)-> { //this method expect consumer object
            System.out.println(item);   //we dont implement consumer interface
        });                             //its is a functional interface(just have **accept** method)
                                        //so we use lambda to implement accept

        list.forEach(item-> System.out.println(item));    //simplify

        list.forEach(System.out::println);                      //use method reference

    }
}
