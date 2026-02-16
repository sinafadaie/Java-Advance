package com.codewithcenna.Generics.Type_Erasure_5;

//we just opened byte code of this class(click on class,open view,show byte code)
//bytecode is a platform independent representation for java code(we can code java once)
//when we compile, compiler produce this byte code that can run on windows,mac,...
//when we run a program, java virtual machine get this bytecode and convert it to native code for target platform(windows...)
//we installed jvm in our os, and this jvm knows how to convert byte code to our native code
//our code--(compiler)--->byte code---(jvm)----->native code(for os)
//--------------------------
//when we compile this generics
//compiler replace all T to Objects class(if we had constraint,replace to that)
//actually in bytecode, it is a non-generic class now!(it replaced to what it had to)
//generics are compile time, type safety(remember compile time type safety)
//it means java compiler will check for type errors at compile time.(because code clear after compile in generics)
//---------------------------
//so compiler will replace T based on constraint(that could be a interface)
//if there is no constraint, replace with Object class
//if we have to constraint, it will replace with the **left most one** in byt code
//this is type erasure(compiler erase all T(type parameter))

public class GenericList<T /*extends Number*/> { //if we add this constraint,items will be arrayed of Numbers in byte code

    private T[] items ;     //items define Object Array in bytecode
                            //its show that internally, our integer,strings,...
                            //are stored in an Object Array
    private int len;
    private int count = 0;

    public GenericList(int len) {
        this.len = len;
        this.items = (T[]) new Object[len];     //after type erasure
                                                //we have something likes
                                                //(Object[]) new Object[len]
                                                //so it's ok, but if we have some constraint and T[]
                                                //replaced with something more specific
                                                //we have problem!

    }
    public void add(T item){    //type of the parameter of this method is Object
        items[count++] = item;
    }

    public T get(int index){
        return items[index];
    }
}
