package com.codewithcenna.Executor_Framework.Waiting_for_First_Task_14;

//if we have multiple Completable future
//and just to find out when one of them is Done
//like we have two API, when one of them succeed ,we are done!
//in this situation we use "anyOf()"
//its return a new CompletableFuture

import com.codewithcenna.Executor_Framework.Callable_and_Futures_3.LongTask;

import java.util.concurrent.CompletableFuture;

public class WaitingDemo {
    public static void show(){

        CompletableFuture<Integer> slowService = CompletableFuture.supplyAsync(() -> {
            LongTask.simulate();
            return 20;
        });

        CompletableFuture<Integer> fastService = CompletableFuture.supplyAsync(() -> {
            return 20;
        });


        CompletableFuture.anyOf(fastService, slowService)                   //its varargs...
                .thenAccept((temp)-> System.out.println(temp));      //"anyOf()" just return one CompletableFuture(the first one)
                                                                            //so it returns "a new CompletableFuture<Object>"

    }
}
