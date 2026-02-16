package com.codewithcenna.Generics.The_Answer_2;

//write angle brackets
//T stand for types or template(T or E(element) is conventional naming)
//use this when we want to implement a class that acts as a collection
//so it can store so many elements
//just like methods can have parameters, classes can have parameters as well
//this T is a type parameter for this class(its type of object we want to store in this list)
//we should pass this parameter, when we create new instance of this class
//-------------------
//in summary T is a type that we say to
//this class, we will define it later



public class GenericList <T>{
    private T[] items ;                        //create array of T type
    private int len;
    private int count = 0;

    public GenericList(int len) {
        this.len = len;
        this.items = (T[]) new Object[len];   //we cant write new T[len]
    }                                         //because compiler doesnt know really T type now
                                              //it can not operate **new** on a type that is not clear now(use witch class?)
                                              //so we create Object type
                                              //and casting that to T type
                                              //because casting occur in runtime, we Bypassing restrictions!
                                              //cast exception, is runtime exception
    public void add(T item){
        items[count++] = item;
    }

    public T get(int index){
        return items[index];
    }
}
