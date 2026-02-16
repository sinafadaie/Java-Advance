package com.codewithcenna.Generics.Inheritance_In_Generics_9;

public class GenericList<T>{
    private T[] items ;
    private int len;
    private int count = 0;

    public GenericList(int len) {
        this.len = len;
        this.items = (T[]) new Object[len];
    }
    public void add(T item){
        items[count++] = item;
    }

    public T get(int index){
        return items[index];
    }
}
