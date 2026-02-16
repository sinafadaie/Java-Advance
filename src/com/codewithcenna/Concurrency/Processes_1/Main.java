package com.codewithcenna.Concurrency.Processes_1;

//A process is an instance of a program or an application
//when you run an app,os load that app inside a process
//so it contains image of application code
//hase some memory and other resources
//-------------------
//you lunch apps simultaneously, so have processes simultaneously
//so we have concurrency at process level
//-------------------
//but in a single process (single application)
//we have concurrency too(multi-threading).
//threads is sequence of instructions
//thread is that thing that execute your code
//--------------------
//each process has at least one thread(main thread)
//but we can create additional threads (concurrency)
//when many client use a web server at same time
//each client have a separate thread, it calls multi-threading
//application witch use multi-thread called multi-threaded application
//--------------------
//these days most processors (cpu), have multiple cores
//if an application just use only one thread, so its not use full power of cpu
//your hardware is wasted
//cpu designed for multi-threading

public class Main {
    public static void main(){
        System.out.println(Thread.activeCount()); //return number of active threads
                                                  //in the current process (2)
                                                  //one of them for the main method
                                                  //the other is in background for garbage collector

        System.out.println(Runtime.getRuntime().availableProcessors()); //number of available threads
                                                                        //its depend on hardware
                                                                        //we have a cpu with 2 core
                                                                        //each core can handle 2 threads
                                                                        //so we have 4 threads available
                                                                        //we will see, we can create so many thread in app
                                                                        //it's not limited to available threads
    }
}
