package com.codewithcenna.Generics.The_problem_1;

public class List {
    private int[] items ;
    private int len;
    private int count = 0;

    public List(int len) {
        this.len = len;
        items =new int[len];
    }

    public void add(int item){
        items[count++] = item;
    }

    public int get(int index){
        return items[index];
    }
}
