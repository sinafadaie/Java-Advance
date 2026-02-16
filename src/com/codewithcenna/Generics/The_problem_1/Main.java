package com.codewithcenna.Generics.The_problem_1;
//we have list class that store int
//so if we want use this class to store another type, we have problem
//for example if we have user class, we cant use this list to save username(we have to create new list base on new type)
//thats create duplicate code and not be scalable!
//-------------------------
//one solution is to use object array,
//object class is the parent of all **reference type**
//do to all classes extend to object class, we can store all objects in this array
//we can store primitive (like int) value too.
//its not an object, its not a reference type, so how?
//because compiler convert it to class,and use valueOf method
//this method returns new instance of the integer class(now its a obj)
//we can do that for all primitives!
//------------------------
//the problems of this solution:
//when you want to store value of this list you need explicit casting
//and if dont cast correctly,you get wrong class cast exception in runtime.

public class Main {
    public void main(){
        var list = new List(10);
        list.add(5);
        System.out.println(list.get(0));

        var olist = new OList(10);
        olist.add('5');
        olist.add(3);                       //Integer.valueOf(3) --compiler convert to this
        System.out.println(olist.get(0));

        int x;
        x = (int) olist.get(1);             //need explicit casting
    }
}
