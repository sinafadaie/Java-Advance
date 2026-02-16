package com.codewithcenna.Collections.Queue_Interface_8;

import java.util.ArrayDeque;
import java.util.Queue;

public class QueueDemo {
    public static void show(){
        Queue <String> queue = new ArrayDeque<>();

        queue.add("a");
        queue.add("b");
        queue.add("c");
        queue.offer("d");        //offer method is like add method
                                    //in some implementation of queue, they have limited size
                                    //in that case, if the queue is full, when we use add method,its throw an exception
                                    //but if we use offer it return false

        System.out.println(queue);  //a is front of queue

        var front = queue.peek();
        System.out.println(front);  //the item remained in queue
        System.out.println(queue);

        front = queue.element();    //its like peek, if queue is null
                                    //peek return null, element throw exception

        front = queue.remove();     //return front item,then remove from queue
        System.out.println(front);

        front = queue.poll();
        System.out.println(front);  //like remove, if the queue is empty, poll return null
                                    //remove throw an exception
        System.out.println(queue);

    }


}
