package com.codewithcenna.Collections.Comparator_Interface_7;

//in pre step we can sort customers
//this because we know that the customer just have name
//so our compareTo method build based on comparing names
//so what if there is more fields? like email,...
//we want to sort customers base on different attribute
//this where we need comparator object to specify witch attribute

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(){
        List <Customer> customers = new ArrayList<>();

        customers.add(new Customer("Sina","e2"));
        customers.add(new Customer("Leila","e1"));
        customers.add(new Customer("Sepehr","e3"));

        EmailComprator emailComprator = new EmailComprator();
        Collections.sort(customers,emailComprator);     //sort method have tow overload
                                                        //one we use pre step(just get a list)
                                                        //one we use here,get a list and a comparator object

        System.out.println(customers);                  //we sort customers based on Email

    }
}
