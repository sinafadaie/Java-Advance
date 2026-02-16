package com.codewithcenna.Executor_Framework.Executors_2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//in java,represent thread pool concept by
//**ExecutorService Interface**
//several classes implement this interface
//ThreadPoolExecutor  (most of the time!)
//ScheduledThreadPoolExecutor ( schedule some task to a thread pool!)
//ForkJoinPool  (recursively split task to smaller task)
//AbstractExecutorService
//-----------
//Executors class is a utility class for thread pools
//has a bunch of static *factory methods* for creating thread pool
//with this class we can create instance of above classes. why?
//because above classes have complex constructor, and It's hard to create instance directly!
//Executors class make it simple for us
//-----------
//in best practice we should shout down
//thread pool in finally block because if we have error
// or exception in run time, and the shout down did not execute,
//its remain in Memory
//-----------
//remember using these tools
//don't solve concurrency problems!
public class ExecutorDemo {

    public static void show(){
        ExecutorService executorService = Executors.newFixedThreadPool(2);          //Executors.newFixedThreadPool create a
                                                                                             //thread pool with fix number of threads
                                                                                             //it create a ThreadPoolExecutor instance

        System.out.println(executorService.getClass().getName());                            //its show ThreadPoolExecutor object
                                                                                             //although the type of variable is ExecutorService
                                                                                             //but the real object in heap is ThreadPoolExecutor

        Collection<Integer> collection = new ArrayList<>();                                  //like this,although the type of variable is collection
        System.out.println(collection.getClass().getName());                                 //but real object is array list
                                                                                             //but we just access collection member

        for (var i=0;i < 10;i++){
            executorService.submit(()->{                                                     //use submit() method to assign tasks to thread pool
                System.out.println("this task owned by " + Thread.currentThread().getName()); //its overloaded,get runnable object or callable object
            });                                                                              //we use lambda to create runnable object(run())
        }                                                                                    //so we don't create thread manually
                                                                                             //they created by ThreadPoolExecutor class (and they are not the main thread)
                                                                                             //internally executorService create a *queue*,and submit task to free threads


        executorService.shutdown();       //when we have thread pool, the app not going to be terminated
                                          //because threads are alive! they are waiting
                                          //we should explicitly shout down our program
                                          //this means I don't want to submit more task
                                          //when all the submitted task get complete, kill the threads
                                          //executorService.shutdownNow()  means kill them now,don't wait to complete tasks
                                          //if we use executorService.submit(()->{  again, we got run time error (threads not exists anymore!)


        //Best Practice:
        ExecutorService executorService2 = Executors.newFixedThreadPool(2);     //just in loop we can create new object with same variable

        try {
            for (var i = 0; i < 10; i++) {
                executorService2.submit(() -> {
                    System.out.println("this task owned by " + Thread.currentThread().getName());
                });
            }
        }
        finally{
            executorService2.shutdown();
        }
    }

}
