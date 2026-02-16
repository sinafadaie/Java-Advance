package com.codewithcenna.Executor_Framework.Handling_Exception_9;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

//in pre lesson we consume the result of CompletableFutureDemo
//but what if it throws an exception?
//----------------
//get() method throw tow type exception
//InterruptedException (for sleeping threads)
//ExecutionException (for error in tasks)
//so when we throw IllegalStateException() in our task
//when get method see it, understand our task has problem
//so it throw a ExecutionException
//but for don't loos the main cause,
//it wraps old exception(IllegalStateException) inside itself (exception chaining)
//so at the end, IllegalStateException is accessible in main thread by ExecutionException
//-----------------
//exceptionally execute before get()
//if our future hase exception, it will map it to a specific value
//and then get(), just see that specific value
//so get() don't throw exception anymore
//in otherworldly exceptionally return **a new** completableFuture **
//it's different from the original one
//get() method just see this new completableFuture object

public class CompletableFutureDemo {
    public static void show(){
        CompletableFuture<IllegalStateException> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("Get the current weather");
            throw new IllegalStateException();              //if we return new IllegalStateException() instead of throw it
        });                                                 //we just simply return an exception object
                                                            //we don't throw it
        /*
        try {
            future.get();                                   //if we don't use get() method
        } catch (InterruptedException e) {                  //main thread don't see exception
            throw new RuntimeException(e);                  //the exception threw in another thread
        } catch (ExecutionException e) {                    //and because its kind of future type
            throw new RuntimeException(e);                  //main thread continue, until we force it to see (by blocking object)
        }*/                                                 //in other word, get can transfer threw exception
    }                                                       //from another thread to main thread(another thread)

    public static void show2(){
        var future = CompletableFuture.supplyAsync(() -> {
            System.out.println("Get the next weather!");
            throw new IllegalStateException();
        });

        try {
            future.get();                                   //get() throw ExecutionException


        } catch (InterruptedException e) {                  //catch exception if we interrupt sleeping thread
            throw new RuntimeException(e);
        } catch (ExecutionException e) {                    //catch exception if something goes wrong in
                                                            //doing task (like here, our task throw exception)

            System.out.println(e.getCause());               //source exception
            System.out.println(e);                          //exception threw by get method
            e.printStackTrace();
        }

        //-----------------

        try {
           var future2 = future.exceptionally(ex-> "last weather is good!")
                    .get();                                 //sometimes we want to, if our task has error (ExecutionException)
                                                            //get() don't throw ExecutionException,do something instead
                                                            //for example return last weather!
                                                            //for this we have exceptionally() method
                                                            //its get a function as argument
                                                            //a function that maps throwable to another type
            System.out.println(future2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            System.out.println("hi");                       //"hi" did not print!
        }                                                   //we still need try/catch block
                                                            //because our lambda can be incorrect
                                                            //or our exception is InterruptedException type
    }
}
