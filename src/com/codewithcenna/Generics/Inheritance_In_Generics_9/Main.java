package com.codewithcenna.Generics.Inheritance_In_Generics_9;

//we have a printUsers method in Utils that hase a genericList of users as parameter
//but in main, if we passed a generic list of instructor, we got compile error
//but why? we expect we can pass Instructor as a child of User
//it is correct that Instructor is child of User,
//but a generic list of  Instructor is not child of generic list of user
//they are arrays, not the exact object
//-----------------------
//look in this way: we saw bytecode in generic list
//generic list just store a array of object(no matter what we passed, just array of object) Object[] items
//whether we pass the user or instructor, we have only a single generic list in our project
//and this class is not a subtype of itself(it is mosh opinion,I think this is not the reason)
//-----------------------
//the reason is :
//Generics in Java are **invariant** (Generic<A> and Generic<B> are considered completely separate types)
//but Arrays are **covariant** (A[], B[] can be related, Array of Objects can have Integer)
//it is for type safety(read summary of section)
//the wild card handle type safety with super and extend
//-----------------------
//so **remember** inheritance is forbid in all generics for type safety
//because if our method get Users, and except child like Instructors
//we can pass Arrays of Instructors
//but due to type erasure we have actually a User Arrays in our generic class
//so we can add Users in this Instructor Arrays (Bomb!)
//so Java Make generics invariant to prevent situation like this (source cause is **type erasure**!)
//-----------------------
//one way to solve this
//is create a new_users based on User
//then iterate on users ant transfer to new_users
//but its not good solution
//the standard solution is **wild card**
public class Main {
    public static void main() {

        User user = new Instructor(20);
        Utils.printUser(user);

        var users = new GenericList<Instructor>(5);
        //Utils.printUsers(users);          its got error

        var newUsers = new GenericList<User>(5);
        //transfer from users to newUsers
    }
}
