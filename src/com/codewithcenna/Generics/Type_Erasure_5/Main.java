package com.codewithcenna.Generics.Type_Erasure_5;


public class Main {
    public void main(){

        GenericList<Integer> glist=new GenericList<>(5);
        GenericList<Integer> list = new GenericList<>(10);

        glist.add(7);
        System.out.println(glist.get(0));


    }
}
