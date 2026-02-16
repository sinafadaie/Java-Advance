package com.codewithcenna.Concurrency.Concurrent_Collection_17;

//I'm smart!
//in pre lesson, we lock all of the object(entire list)
//its not good for performance, we can just lock a partition of our object!
//partitioning technic is divide our data into segments and
//different threads can concurrently work with different segments(lock segments)
//obviously concurrent collection is so faster than synchronized collections
//-----------
//"concurrent" collection declared in java.util.concurrent package


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentDemo {
    public static void show(){
        //Map<Integer,String> map = new HashMap<>();    //regular map has concurrency problem

        Map<Integer,String> map = new ConcurrentHashMap<>();    //Map is interface
        map.put(1,"a");                                         //HashMap,ConcurrentHashMap are implementations
        map.get(1);                                             //so we replaced it easily
                                                                //ConcurrentHashMap locks segment, not entire object
    }
}
