package com.codewithcenna.Executor_Framework.Running_on_Completion_8;

import java.util.concurrent.CompletableFuture;

//sometimes we need to execute some code when an
//"asynchronous" operation completes
//CompletableFuture has some methods for this.
//these methods come from CompletionStage Interface
//"then" means when task is finished

public class CompletableFutureDemo {
    public static void show(){

        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            return 1;
        });

        future.thenRun(()-> System.out.println("Im done with main thread: " +               //thenRun get a runnable object
                Thread.currentThread().getName()));                                         //so we implement run()
                                                                                            //obviously its blocking main

        future.thenRunAsync(()-> System.out.println("Im done with another thread: " +       //if we want to execute this new task
                Thread.currentThread().getName()));                                         //in Asynchronous fashion and in another thread
                                                                                            //we can use thenRunAsync instead thenRun

        future.thenAccept(result->{                                                  //thenAccept get a consumer object
            System.out.println(result +" "+ Thread.currentThread().getName());              //so we implement Accept()
        });                                                                                 //its declarative way
                                                                                            //the context (result) is transfer to thenAccept method


        future.thenAcceptAsync(result->{                                             //if we want to execute this new task
            System.out.println(result +" "+ Thread.currentThread().getName());              //in Asynchronous fashion and in another thread
        });                                                                                 //we can use thenAcceptAsync instead thenAccept

    }
}
