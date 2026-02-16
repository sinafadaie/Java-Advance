package com.codewithcenna.Generics.The_Answer_2;

//generics solves pre problems
//we want a generic list class to store different types of objects
//----------
//when we create new instance
//type of T will be clear
//and the compiler **suggest** methods argument compatible by T
//also return type of method is declared
//so we dont need explicit casting anymore
//this is benefit of Generics


public class Main {
    public void main(){

        var glist = new GenericList<Integer>(10);   //create integer list
        glist.add(3);

        var glist2 = new GenericList<String>(10);
        glist2.add("sina");
        System.out.println(glist2.get(0));

    }
}
