package com.codewithcenna.Generics.Comparable_Interface_6;
//Comparable is an interface to compare
//it's used in a lot of sorting algorithm
//it's a generic interface to useful for many classes(it has type parameter)

public class User implements Comparable<User>{ //its passing type parameter,
     private int point;                        //it's not create generic,Comparable is generic interface itself
                                               //we want to use it

    public User(int point) {
        this.point = point;
    }

    @Override                                  //use red lamp at class name //the concept is:
    public int compareTo(User other) {
        return this.point-other.point;
    }
}
