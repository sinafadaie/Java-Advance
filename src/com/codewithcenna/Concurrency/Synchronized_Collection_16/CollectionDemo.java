package com.codewithcenna.Concurrency.Synchronized_Collection_16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

//we have race condition here
//addAll is not atomic operation
//at beginning collection size = 0
//Thread A wants to add {1, 2, 3}
//Thread B wants to add {4, 5, 6}
//During these steps:
//Both threads might see size = 0 at the same time
//Both start writing at index 0
//One thread may overwrite the data of the other
//------------------------
//we can use Synchronized collection to solve this
//Synchronized means its lock the collection (just one thread can enter)
//everywhere see "synchronized", it means act like "Locking"



public class CollectionDemo {
    public static void show(){
        Collection<Integer> regularCollection = new ArrayList<>();
        Collection<Integer> synchronizedCollection =
                Collections.synchronizedCollection(new ArrayList<>());   //Collection<Integer> regularCollection = new ArrayList<>()
                                                                         //means we have ArrayList internally in heap but the type is collection
                                                                         //just access to collection member(not the arrays one)
                                                                         //Collections.synchronizedCollection put this array in synchronized block
                                                                         //in other word, we locked it, just one thread can access to it,
                                                                         //we pass to synchronized whole our ArrayList(we lock our list totally)
                                                                         //it like we pass "this" by "new" object we created

        Thread thread1 = new Thread(()->{
            regularCollection.addAll(Arrays.asList(1,2,3));         //Arrays.asList(1,2,3)
            synchronizedCollection.addAll(Arrays.asList(1,2,3));    //Assume these values are in a temporary array, then expose it as a List:
        });                                                         //internally :Integer[] temp = {1, 2, 3};
                                                                    //List<Integer> list = Arrays.asList(temp);
                                                                    //Arrays is utility class for arrays
        Thread thread2 = new Thread(()->{
            regularCollection.addAll(Arrays.asList(4,5,6));
            synchronizedCollection.addAll(Arrays.asList(4,5,6));
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("regularCollection: " + regularCollection);
        System.out.println("synchronizedCollection: "  + synchronizedCollection);
    }
}
