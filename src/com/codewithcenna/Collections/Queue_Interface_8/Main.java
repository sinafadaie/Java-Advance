package com.codewithcenna.Collections.Queue_Interface_8;

//Queue Interface is extend to Collection Interface
//so every queue is a collection as well
//queue process job based on the order we receive them
//like a printer in an office
//many classes have been implemented queue interface,
//but ArrayDeque, PriorityQueue is used more than the other
//ArrayDeque : Double Ended Queue(special queue that has two ends, so items can enter the queue from either end)
//in normal queue the items always enter the queue from the back
//priorityQueue : it is a queue where each item get a priority.
//and this priority determine the position of item in the queue(high priority, is in the front of the queue)
//os use this queue to manage processes


public class Main {
    public static void main(){
        QueueDemo.show();
    }
}
