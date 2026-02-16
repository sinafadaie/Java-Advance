package com.codewithcenna.Generics.Inheritance_In_Generics_9;

public class Utils {
    public static <T extends Comparable<T>> T gmax (T first, T second){
        return ((first.compareTo(second)) < 0) ? second : first;
    }

    public static void printUser(User user){ //print one user
        System.out.println(user);
    }

    public static void printUsers(GenericList<User> users) {       //print list of users
                                                                   //this method get a generic list of users
    }
}
