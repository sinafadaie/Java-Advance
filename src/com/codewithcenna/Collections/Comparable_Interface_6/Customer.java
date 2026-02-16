package com.codewithcenna.Collections.Comparable_Interface_6;

public class Customer implements Comparable<Customer> { //what type of object want to be compared
    private String name;                                //Customer type --> <Customer>

    public Customer(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Customer other) {
        return this.name.compareTo(other.name);     //String is a comparable object
    }                                               //so we just use compareTo method on String
                                                    //remember compareTo return 0,positive value,negative value

    @Override
    public String toString() {                      //for print
        return this.name;
    }
}
