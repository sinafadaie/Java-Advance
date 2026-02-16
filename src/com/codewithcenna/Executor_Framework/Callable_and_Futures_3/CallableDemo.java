package com.codewithcenna.Executor_Framework.Callable_and_Futures_3;

//sometimes our task has returned something
//for example instead of downloading, we call an API
//that's the time we use callable interface,
//Interface Callable<V> (V is return type)
//it is functional interface with call() method
//--------------
//submit() method was over loaded
//so if our lambda return something, it's a callable obj
//--------------
//Future is an interface that represent future result of an operation,
//an operation that complete in future
//submit don't wait to return result
//its continue the program after put task in queue
//so if our task return something (use callable object)
//we need a variable that accept this situation!
//Future<Integer> means we know its integer,
//but don't wait, continue the program, as soon as it ready put it there

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableDemo {

    public static void show(){
        ExecutorService executor = Executors.newFixedThreadPool(2);

        try{
            Future<Integer> future = executor.submit(() -> {                   //implement call() method with lambda
                LongTask.simulate();                                           //submit don't wait,its continue program with main thread ,
                return 1;                                                      //and stores future result in future type
            });
           /* try {                      ------------------------------------>if we use future value
                Integer result = future.get();                                like future.get()
                System.out.println(result);                                   then the program said so we need it now
            } catch (InterruptedException e) {                                if it's not ready, we should wait!
                throw new RuntimeException(e);                                so if we uncomment here
            } catch (ExecutionException e) {                                  we don't see "see me immediately!" immediately,
                throw new RuntimeException(e);                                the program stopped here
            }                                                                 in other word get() method is "block" method
                                                                              blocked the main thread!
            */

        }finally{
            executor.shutdown();
        }

        System.out.println("see me immediately!");                  //see this immediately, so it means
                                                                    //submit method don't wait for the result!
                                                                    //its continue program with main thread
                                                                    //just put task in queue for thread pool and continue!
    }

}
