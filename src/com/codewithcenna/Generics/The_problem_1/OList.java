package com.codewithcenna.Generics.The_problem_1;

public class OList {
    private Object[] items ;
    private int len;
    private int count = 0;

    public OList(int len) {
        this.len = len;
        items =new Object[len];
    }

    public void add(Object item){
        items[count++] = item;
    }

    public Object get(int index){
        return items[index];
    }
}
