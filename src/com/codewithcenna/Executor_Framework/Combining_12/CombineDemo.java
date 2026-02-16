package com.codewithcenna.Executor_Framework.Combining_12;
import java.util.concurrent.CompletableFuture;

//we can combine two CompletableFuture
//and create a new complex CompletableFuture
//and do it in Asynchronous fashion!
//-------------------------------
//consider that
//firstTask and secondTask execute in parallel
//because of "thenCombine"
//and whole code is Async, the main thread
//don't block anywhere

public class CombineDemo {
    public static void show(){

        CompletableFuture<String> firstTask =                                           //we have to query DB to find price of product
                CompletableFuture.supplyAsync(() -> {return "20 $";})                   //it's a long time operation
                        .thenApply((price)->{return price.replace(" $","");});

        CompletableFuture<Double> secondTask = CompletableFuture.supplyAsync(() -> {    //imagine we have API to find
            return 0.9;                                                                 //uro rate
        });                                                                             //it's a long time operation ...

        firstTask
                .thenCombine(secondTask,(price,rate)->{return Integer.parseInt(price) * rate;})
                .thenAccept((price)-> System.out.println(price));                //thenCombine get a Completable object (for combining)
                                                                                        //and a BiFunction (first argument is firstTask result)
                                                                                        //                 (second argument is secondTask result)
                                                                                        //and its continue the stream by new uro price CompletableFuture type
    }
}
