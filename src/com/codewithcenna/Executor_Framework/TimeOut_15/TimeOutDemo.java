package com.codewithcenna.Executor_Framework.TimeOut_15;

import com.codewithcenna.Executor_Framework.Callable_and_Futures_3.LongTask;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

//when calling a remote service, you want to have a limit
//in terms of how long we are willing to wait to get a response
//we don't want to wait forever
//so we have to method on CompletableFuture
//both of them return "a new completable future"
//orTimeout (throw exception)
//completeOnTimeout (default value)

public class TimeOutDemo {
    public static void show(){

        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            LongTask.simulate();
            return 1;
        });

        future.orTimeout(1, TimeUnit.SECONDS);  //get two parameter(value of time,unit of time)
                                                        //its return new CompletableFuture
                                                        //if it doesn't done after 3 second, throw exception
                                                        //we should use get() to catch exception

        //--------------

        CompletableFuture<Integer> future1 =                                          //it hase default value of 2
                future.completeOnTimeout(2, 3, TimeUnit.SECONDS);       //if it is not Done after 3 second
                                                                                      //its return a CompletableFuture of 2

        future1.thenAccept((item)-> System.out.println(item));                //because it uses another thread
                                                                                     //we need delay!
    }
}