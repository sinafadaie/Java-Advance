package com.codewithcenna.Generics.Wild_Card_10;

//when we use wild card, java compiler create an anonymous type under the hood
//it creates class CAP#1 (a method can get multiple wildcard so number 1)
//we don't see it,but its there
//------------
//in summary
//when we use GenericList<? extends User>
//we can pass all user object(user,instruction,..)
//but because of capture class is lower than User class
//its add method cant add user object(capture class didn't know user class well,
//and dont have any idea about instruction object)
//so you cant modify the list at this level
//but you can get information from both user and instruction lists
//when we use GenericList<? super User>
//capture class is above user class
//we can not pass all user object(user,instruction,..)
//just we can pass user or instruction. its because type safety
//if we can get both of them, we have **ability** to add both user and instruction object
//because capture class is above them,and know them well (can use his add method)
//so compiler prevent it at first.
//in super mood we can read to(but because we should pass exact that clas
//we have more restriction rather than extend mood)
//-----------------
//summary:
//when our wild card is extended in a method, its means the capture class is small
//we can pass any polymorphism (full access to subclasses)to method, but modifying is disabled
//so when we want read from list use "extend keyword"
//when our wild card is supered in a method, its means the capture class is large
//we just can pass exact type(restrict access) to method, but modifying is enabled
//so when we want to write to list use "super keyword"

import com.codewithcenna.Generics.Inheritance_In_Generics_9.User;
import com.codewithcenna.Generics.Inheritance_In_Generics_9.GenericList;
import com.codewithcenna.Generics.Inheritance_In_Generics_9.Instructor;

public class Utils {
    public static <T extends Comparable<T>> T gmax (T first, T second){
        return ((first.compareTo(second)) < 0) ? second : first;
    }

    public static void printUser(User user){
        System.out.println(user);
    }

    public static void printUsers
            (GenericList<? extends User> users) {    //the compiler when see GenericList<?>
                                                             //create a capture class (cap#1) instead of GenericList<?>
                                                             //its a anonymous type, we dont see it,but its there
                                                             //so now users is type of cap#1
                                                             //when we write ? extend user, so the capture class is extended to user class(it has user member)

        users.get(0);            //get method come from capture class
                                 //its just return a instance of this capture class
                                 //zero is index of list

        User x = users.get(0);   //because User is capture class father
        Object y = users.get(0);
    }

    public static void addUsers(GenericList<? super User> users){   //we say that the capture class is father of user class
                                                                            //compiler consider it like object class now
                                                                            //so what we can pass?just the exact User
        users.add(new User(20));
        users.add(new Instructor(30));                                //Instructor is kind of capture class now
                                                                            //in printUsers capture class and Instructor are so different(its clear)

         //User x = users.get(0);    its get error,because this object is not kind of user,its father of user
         Object x = users.get(0);
    }
}