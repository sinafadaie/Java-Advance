package com.codewithcenna.Collections.Comparator_Interface_7;

public class Customer implements Comparable<Customer> {
    private String name;
    private String email;

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
    }

@Override
    public int compareTo(Customer other) {
        return this.name.compareTo(other.name);
    }

    @Override
    public String toString() {
        return this.name;
    }

    public String getEmail() {
        return email;
    }
}
