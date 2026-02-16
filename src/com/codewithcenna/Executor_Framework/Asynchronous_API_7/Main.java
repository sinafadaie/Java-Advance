package com.codewithcenna.Executor_Framework.Asynchronous_API_7;

//we have a very powerful technic that can
//convert all synchronous object (blocking object)
//to Asynchronous object (non-blocking object)
//by using CompletableFuture
//--------------
//sending Email is long-running operation
//anytime we have to touch file system
//dealing with network
//querying databases
//calling remote service
//these are long-running operations
//we should write these operations in Asynchronous fashion
//(run them in a separate threads(not main thread))
//in synchronous way, we're blocking the main thread = blocking App!

public class Main {
    public static void main(){

        var service = new MailService();
        service.send();     //this is blocking
                            //synchronous way!

        System.out.println("Im waiting");

        //---------------

        service.sendAsync();
        System.out.println("Im not waiting!");      //why it doesn't write "Email was sent" again
                                                    //because main thread terminate earlier
                                                    //if we put some delay on main thread to terminate after
                                                    //other thread, we can see "Email was sent"
        /*
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        */
    }
}
