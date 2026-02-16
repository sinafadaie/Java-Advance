package com.codewithcenna.Collections.Why_Need_Iterable_2;

//due to we break oop concept
//if we change implementation like replace array with ArrayList
//we will get some error
//its very bad in large application

public class GenericList<T extends  String> {

    public T[] items ;  //public ArrayList<T> items = new  ArrayList<>();

    private int len;
    private int count = 0;

    public GenericList(int len) {
        this.len = len;
        this.items = (T[]) new String[len];
    }
    public void add(T item){    //type of the parameter of this method is Object
        items[count++] = item;
    }

    public T get(int index){
        return items[index];
    }
}
