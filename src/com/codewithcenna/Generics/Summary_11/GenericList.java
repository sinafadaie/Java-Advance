package com.codewithcenna.Generics.Summary_11;

//it's so important to know this statement: (T[]) new Object[len]
//is just a compile time lie, it just says to compiler be quiet
//open the byte code and see what is the items type.
//it's just fucking an object array,no matter what we pass T
//its erased and replaced with object
//so when we pass something like "var list = new GenericList<Integer>(4)"
//or "var list2 = new GenericList<String>(4)"
//we maybe think because of (T[]) new Object[len] the list is int array, or list2 is string array,
//but it is wrong, (T[]) new Object[len] is lie to compiler,to be quiet
// T replace with object, and both **list, list2 are object array**!!
//so if we want to cast list to an int array we got error in run time
//we cant cast object[] to int[] (Arrays type safety)
//---------------------------------------
//so Generics + Arrays = so dangerous
//you have high risk in run time(because arrays are covariant,
//                               and we used that to pass any type!,create object[] to store all type array)
//but with this, you create potential to creating something like impossible casting
//its shows itself in runtime(so its dangerous)
//---------------------------------------
//in best practice you should always hide these arrays behind methods(don't expose them to other class)
//and restrict them to a compatible type(BY CONSTRAINT)
//we say we should hide, because when jvm see array it checked it and expect it's a T type array.
//jvm expect list array is an integer array, but see what the fuck it's an object aray(pashmash mirize)
//every where jvm see our array other place throw exception
//in the generic class itself, due to type erasure, jvm cant see problem!

public class GenericList<T> {

    public T[] items ;      //we make it public to see in main
    private int len;
    private int count = 0;

    public GenericList(int len) {
        this.len = len;
        this.items = (T[]) new Object[len];     //its jus compile time **lie**
                                                //items array is always be an object array
                                                //no matter what we pass to T
                                                //after compile its erase and replace with Object
    }
    public void add(T item){    //type of the parameter of this method is Object
        items[count++] = item;
    }

    public T get(int index){
        return items[index];
    }
}
