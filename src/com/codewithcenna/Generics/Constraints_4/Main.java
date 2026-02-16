package com.codewithcenna.Generics.Constraints_4;

//sometimes we want to implement a restriction to our generics
//for example our generic maybe meaning full just for numbers
//and we want to prevent using our generics for the others
//in this case we add constraints on type parameter

public class Main {
    public void main(){
        //new GenericList<String>(10);   get error to our constraint
        GenericList<Integer> glist=new GenericList<>(5);
        GenericList<Integer> list = new GenericList<>(10);

        glist.add(7);
        System.out.println(glist.get(0));


    }
}
