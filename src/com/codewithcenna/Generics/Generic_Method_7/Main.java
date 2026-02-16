package com.codewithcenna.Generics.Generic_Method_7;

//in generic class, all methods are generic,
//but we can have a generic method in a non-generic class(we want just a method be generic)


public class Main {
    public static void main() {

        System.out.println(Utils.max(5,7));  //we want to max method be generic

        var user1 = new User(10);
        var user2 = new User(20);
        System.out.println(Utils.gmax(user1,user2));    //its print address of user object
                                                        //so we override toString in User class
                                                        //we can use gmax on users obj, because the User class implement Comparable interface

    }
}
