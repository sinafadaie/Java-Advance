package com.codewithcenna.Collections.Map_Interface_10;

import com.codewithcenna.Collections.Comparator_Interface_7.Customer;

import java.util.HashMap;
import java.util.Map;

//Map interface does not extend to collection Interface
//so it is not a collection!(but it is part of java collections framework)
//it is use *Hash table* to can access items by O(1)
//its not extended to iterable interface,so it's not iterable (no foreach loop)
//this interface implemented by so many classes, but the most use full one is **HashMap**
//--------------
//hase toe generic type (K,V)(Key,Value)
//mapping a key to value
//key is the one we have (we have email,and want to find customer with that email)
//--------------
//the order of map is not guaranteed, like set

public class MapDemo {
    public static void show(){
        Map<String, Customer> map = new HashMap<>();    //key is string,value is customer

        var c1 = new Customer("a","e1");
        var c2 = new Customer("b","e2");

        map.put(c1.getEmail(),c1 );                                  //fill the map
        map.put(c2.getEmail(),c2 );

        var customer =  map.get("e1");
        System.out.println(customer);                                //find customer by email with O(1)

        customer = map.get("e10");                                   //if there is not any, it returns null
        System.out.println(customer);

        customer = map.getOrDefault("e10",c1);                  //getOrDefault if dont find any customer,return default customer
        System.out.println(customer);

        var exists=map.containsKey("e10");                          //is exist a customer with this email?
        System.out.println(exists);                                 //its a boolian

        map.replace("e1", new Customer("aa","e1"));     //replace customer
        System.out.println(map);

        //------loop on maps
        //the maps are not iterable but...

        for (var key : map.keySet()){                               //we can iterate on keys(keySet is iterable)
            System.out.println(key);
        }

        for(var value : map.values()){                               //they are customers
            System.out.println(value);
        }

        for (var entry : map.entrySet()) {                          //entrySet return set, and sets were iterable
            System.out.println(entry);                              //like e1=aa (its like iterate on map)
                                                                    //convert map to set and we can iterate on it

            System.out.println(entry.getKey());                     //we access to key and value on entry
            System.out.println(entry.getValue());
        }

    }
}
