package com.codewithcenna.Collections.Comparator_Interface_7;

import java.util.Comparator;

public class EmailComprator implements Comparator<Customer> {

    @Override
    public int compare(Customer o1, Customer o2) {
        return o1.getEmail().compareTo(o2.getEmail());
    }
}