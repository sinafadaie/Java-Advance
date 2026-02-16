package com.codewithcenna.Generics.Wild_Card_10;

//wild card represent unknown type --->?
//now we can pass a list of anythings
//but its not good, we want some restriction
//so we can add constraint to wildcards with extend(we add to printUsers method)

import com.codewithcenna.Generics.Inheritance_In_Generics_9.User;
import com.codewithcenna.Generics.Inheritance_In_Generics_9.Instructor;
import com.codewithcenna.Generics.Inheritance_In_Generics_9.GenericList;

public class Main {
    public static void main() {

        User user = new Instructor(20);
        Utils.printUser(user);

        var users = new GenericList<Instructor>(5);
        Utils.printUsers(users);
       // Utils.addUsers(users);  get error,because we pass a instructor list
                                 //but we can add a user element with this method
                                 //its so critical for compiler(type safety of array)
                                 //so prevent it at first

        var newUsers = new GenericList<User>(5);
        Utils.addUsers(newUsers);                       //just add a new user with point 20
                                                        // and new instructor with point 30
    }
}
