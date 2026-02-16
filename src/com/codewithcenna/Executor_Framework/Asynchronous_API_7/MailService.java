package com.codewithcenna.Executor_Framework.Asynchronous_API_7;
import com.codewithcenna.Executor_Framework.Callable_and_Futures_3.LongTask;
import java.util.concurrent.CompletableFuture;

//sendAsync executed on separate thread on common thread pool
//if you have a synchronous method
//you can convert it to Asynchronous method
//by wrapping it inside a completable future object

public class MailService {
    public void send(){
        LongTask.simulate();          //with this, we simulate sending Email
                                      //as long-running operation

        System.out.println("Mail was sent");
    }

    public CompletableFuture<Void> sendAsync(){          //when we convert synchronous method to Asynch
                                                         //in convention, the method name has "Async" at the end

        return CompletableFuture.runAsync(()->send());   //because our task return void
                                                         //we use runAsync and pass runnable object
                                                         //otherwise we should use supplyAsync
    }
}
