package com.codewithcenna.Generics.Constraints_4;

//constraints are classes and interfaces
//we can define multiple constraint with &
//its not logical operand(&&), but actually it means and(&&)
//------------
//Comparable is an interface
//we use this interface for implementing classes
//that can be compared with each other
//for example if user class is comparable
//we can compare tow user objects(like their last login date)
//------------
//Generics in Java exist only at compile time.(due to type erasure)
//But arrays keep their real type at runtime. (Arrays type is clear always)
//Because of this difference, combining Generics and Arrays is sensitive and tricky.(due to Arrays type safety)
//you should check after "type erasure"
//we have possible casting on Arrays
//we have high potential to get runtime error (because types are changed due to,type erasure)

public class GenericList<T extends Number & Comparable> {        //its constraints on type parameter
    private T[] items ;                                          //so extend must be in <>
    private int len;                                             //now T is just can be Number class(or children)(Number Class is parent of Integer,Short,... classes)
    private int count = 0;                                       //this mean T must be a numeric Comparable type

    public GenericList(int len) {
        this.len = len;
        this.items = (T[]) new Number[len];                     //we cant write  (T[]) new Object[len]

        //this.items = (Integer[]) new Object[len];             //------------>(its get compile time error)
                                                                //compiler figure out, its impossible casting!
                                                                //if you can manipulate compiler somehow, jvm throw casting exception certainly
                                                                //so check the code to we haven't like this after type erasure
                                                                //its about **Arrays** type safety!
                                                                //because we have An Arrays of Object in heap(Object[len])
                                                                //and it can contain any Objects, so we cant cast it to Arrays of Integer (Arrays type safety)
    }
    public void add(T item){
        items[count++] = item;
    }

    public T get(int index){
        return items[index];
    }
}
