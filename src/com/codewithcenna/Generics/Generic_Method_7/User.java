package com.codewithcenna.Generics.Generic_Method_7;


public class User implements Comparable<User>{
     private int point;

    public User(int point) {
        this.point = point;
    }

    @Override
    public int compareTo(User other) {
        return this.point-other.point;
    }

    @Override
    public String toString() {
        return "point: " + this.point;
    }
}
