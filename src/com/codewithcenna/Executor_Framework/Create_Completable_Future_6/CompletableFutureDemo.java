package com.codewithcenna.Executor_Framework.Create_Completable_Future_6;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

//CompletableFuture class has two method we use
//to create completable future object
//if our task don't return, we use runAsync()
//if our task return something, we use supplyAsync()
//its declarative in this level:we have task
//use thread pool
//do it Asynchronous!
//------------------
//runAsync():
//its run task in an asynchronous(non-blocking) fashion
//it get (a runnable object) or (runnable object + Executor)
//if we just passed a runnable object, it uses "common pool" (as a default pool)
//-------------------
//commonPool is a thread pool that well aware of the
//number of available threads.
//we have "custom pool" to create pool with less or more threads
//common pool is "singleton", its created when jvm started
//and exist until jvm is alive,
//never shout down common pool(we can do that!,but never do it!)
//--------------------
//supplyAsync():
//its run task in an asynchronous(non-blocking) fashion
//its get (a supplier object) or (a supplier + Executor)
//if we just passed a supplier object, it uses "common pool" (as a default pool)
public class CompletableFutureDemo {
    public static void show(){
       // ForkJoinPool.commonPool();  we can return commonPool with this

        CompletableFuture.runAsync(()-> System.out.println("hi: "+  //we just pass a runnable object
                Thread.currentThread().getName()));                 //so it create common pool under the hood
                                                                    //with this line we execute our task in asynchronous way
                                                                    //don't need to create thread pool,don't need to submit task
                                                                    //don't need to shut down threads
                                                                    //we just call runAsync()
                                                                    //its **declarative** pattern,
                                                                    //we said what to be done, not how!

        CompletableFuture<Integer> future =
                CompletableFuture.supplyAsync(() -> {
                    System.out.println("Hello: " +                  //we implement get method of supplier interface by lambda
                            Thread.currentThread().getName());      //its return a completableFuture <Integer>
                    return 1;                                       //its **declarative** pattern
        });                                                         //it's going to assign this task to another threads
                                                                    //and handle other things!

        try {
            System.out.println(future.get());                       //get() is block method
        } catch (InterruptedException e) {                          //but CompletableFuture have "some tools"
            throw new RuntimeException(e);                          //to prevent blocking main thread
        } catch (ExecutionException e) {                            //see in next lessons
            throw new RuntimeException(e);                          //because it creates a synchronous stage
        }


        for(var i =0; i<10; i++){                                   //common pool is unique
            CompletableFuture.runAsync(()->{                        //its never gone
                System.out.println("By By: "+                       //so in each iteration, it submits new task to our common pool
                        Thread.currentThread().getName());          //and in each iteration, it's not waiting
            });                                                     //(submit the task and continue the loop)--->because its future
        }                                                           //and we have tools to continue program asynchronous --->main goal of "CompletableFuture"
    }
}
