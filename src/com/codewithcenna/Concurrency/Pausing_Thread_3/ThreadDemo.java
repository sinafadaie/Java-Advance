package com.codewithcenna.Concurrency.Pausing_Thread_3;

//we can pause a thread after it started
//with sleep method
//---------
//now we start all 10 thread simultaneously (no pending)
//and all of them is finished simultaneously after 5 second
//if we use one thread, it will take 50 second to download all of them!
//----------
//we just have 4 thread available, how we can start 10 thread in parallel?
//its because jvm has what we call a thread scheduler
//"thread scheduler" decide what threads to run for how long
//if we have more task more than available thread
//"thread scheduler" switch between these tasks giving each a slice of the cpu time
//its happens so fast that gives us the illusion that they are executed in parallel
//but that is parallelism at software level! in hardware its just switching!

public class ThreadDemo {
    public static void show(){

        System.out.println(Thread.currentThread().getName());

        for (var i=0;i<10;i++){
            Thread thread1 =new Thread(new DownloadFileTask());
            thread1.start();
        }
    }
}
