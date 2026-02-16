package com.codewithcenna.Executor_Framework.Waiting_for_Tasks_13;

import com.codewithcenna.Executor_Framework.Callable_and_Futures_3.LongTask;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

//when we have one CompletableFuture
//we can use "thenRun" to execute some code
//after the CompletableFuture object is done
//but if we have so many completableFuture objects
//we cant figure out when all of them is done to do something
//"allOf()" method is to find out when completableFutures are done
//its return "a new CompletableFuture" object
//so we can use "thenRun" to execute some code now!
//--------------------
//consider that get() method is not a blocking method now!
//this task is going to get executed asynchronously
//when all these tasks are complete
//maybe you think,this is true when we use "thenRunAsync"
//but this is true now too
//thenRun executes on the same thread that completes the Future,
//not on the main thread(its execute on common pool!)

public class WaitingDemo {
    public static void show(){

        CompletableFuture<Integer> firstTask = CompletableFuture.supplyAsync(() -> {
            LongTask.simulate();
            return 1;});

        CompletableFuture<Integer> secondTask = CompletableFuture.supplyAsync(() -> {return 2;});
        CompletableFuture<Integer> thirdTask = CompletableFuture.supplyAsync(() -> {return 3;});

        CompletableFuture<Void> all =
                CompletableFuture.allOf(firstTask, secondTask, thirdTask);  //its get varargs(...) of CompletableFuture
                                                                            //its return a new CompletableFuture
                                                                            //when this CompletableFuture is Done, means all CompletableFutures are Done!
                                                                            //its return CompletableFuture<Void>
                                                                            //but why "Void"?
                                                                            //because firstTask,secondTask,thirdTask
                                                                            //can be in different type.
        all.thenRun(()-> System.out.println("All tasks are Done!"));

        all.thenRun(()->{
            try {
                Integer firstValue = firstTask.get();                       //consider that get() method is not a blocking method now!
                System.out.println(firstValue);                             //this task is going to get executed asynchronously
            } catch (InterruptedException e) {                              //when all these tasks are complete
                throw new RuntimeException(e);                              //maybe you think,this is true when we use "thenRunAsync"
            } catch (ExecutionException e) {                                //but this is true now too
                throw new RuntimeException(e);                              //thenRun executes on the same thread that completes the Future,
            }                                                               // not on the main thread(its execute on common pool!)
        });

        System.out.println("see me immediately, so main doesn't blocked!");
        //-----------------
        all.join();                                                         //join on CompletableFuture means Done too
                                                                            //and it returns final value of a completableFuture
        Integer value = firstTask.join();                                   //so we can store the value!
        System.out.println(value);

    }
}
