package com.codewithcenna.Generics.Primitives_In_Generics_3;
import com.codewithcenna.Generics.The_Answer_2.GenericList;

//we can only use reference type as generic type argument
//we cant write "new GenericList<int>(10)"
//if we want to store primitives inside generics, we have to use **wrapper class**
//every primitives (int,float,short,...) have a wrapper class
//Integer for int
//Short for short and ...
//this classes are reference type that stores those primitives
//----------------------
//in general when compiler see primitives
//but expect objects
//use boxing/unboxing technic
//----------------------
//objects are in heap and can get null (a null pointer(thats because we can initiate a obj with null))
//primitives are in stack and cant get null (they should have value)

public class Main {
    public void main(){

       GenericList<Integer> numbers = new GenericList<>(10);    //when we use class name instead var
                                                                    //we can don't pass type parameter again after new
                                                                    //its unnecessary(it just duplicate)

        numbers.add(1);             //despite add method accept integer object
                                    //we just pass a primitive integer
                                    //java compiler automatically wrap this value
                                    //inside an instance of the integer class
                                    //in other word, its create new instance of integer class to store this value
                                    //this process is called **Boxing**
                                    //compiler put this primitive value inside a box,a box in an object
                                    //compiler do this with wrapper class

        int number = numbers.get(0);//reversally it is unboxing

    }
}
