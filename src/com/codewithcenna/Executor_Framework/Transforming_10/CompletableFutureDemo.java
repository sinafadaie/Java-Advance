package com.codewithcenna.Executor_Framework.Transforming_10;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

//we have completable future that we want to
//convert it to another type or data structure
//--------------
//we can build complex asynchronous operations
//in a declarative way.
//It's like stream, it can continue
//--------------
//thenApply get function return new completableFuture
//thenAccept get consumer, so we can access the value(like get)
//thenRun, just doing something after task
public class CompletableFutureDemo {

    public static int mapTemperature(int temp){
        return (int) (temp * 1.8 +32);
    }

    public static void show(){

        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {   //imagine we have an API,
            return 20;                                                              //when we call it, it returns temperature in Celsius
        });                                                                         //it returns 20 degrees in this case

        var fahrenheitTemp = future.thenApply(temp->{return mapTemperature(temp);});     //thenApply return **a new completable Future**
                                                                                                //so until we use get, it's not going to check
                                                                                                //this is ready or not
        System.out.println(fahrenheitTemp);                                                     //you’re actually printing the CompletableFuture object itself,
                                                                                                // not the value inside it.

        try {
            System.out.println(fahrenheitTemp.get());                                           //when we use get
        } catch (InterruptedException e) {                                                      //we want the actual value
            throw new RuntimeException(e);                                                      //block the thread for getting value
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

        //-----------------------
        //declarative way

        future.thenApply(CompletableFutureDemo::mapTemperature)                                  //create new completableFuture in this line
                .thenAccept((temp)-> System.out.println(temp));                           //use a consumer to consume this context object
                                                                                                 //because it needs to consume value, we should wait until value is ready
                                                                                                 //blocking the main

        future.thenApply(CompletableFutureDemo::mapTemperature)
                .thenAcceptAsync((temp)-> System.out.println(temp));                     //or use Async, to do that in another thread
    }
}
