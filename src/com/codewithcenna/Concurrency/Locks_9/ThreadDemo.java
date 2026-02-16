package com.codewithcenna.Concurrency.Locks_9;
import java.util.ArrayList;
import java.util.List;

//I was tried to use com.codewithcenna.Concurrency.Race_Condition_7.DownloadFileTask; instead copying file,
//but it got error, because its constructor get DownloadStatus
//and DownloadStatus in com.codewithcenna.Concurrency.Race_Condition_7.DownloadFileTask
//come from  com.codewithcenna.Concurrency.Race_Condition_7.DownloadStatus
//the compiler said you are passing status to constructor that is not the right one!
//------------------
//another strategy for preventing race conditions and visibility problems
//is to prevent multiple threats from accessing an object at the same time
//this is called **Synchronization**
//we synchronize threads by using locks
//------------------
//we put lock on a block of our code and jvm will
//ensure that only one thread at a time can execute that block,
//that block of our code called "critical section"
//other thread wait,until inside thread come out
//so our code inside "critical section executed" sequentially

public class ThreadDemo {
    public static void show(){

        var status = new DownloadStatus();
        List<Thread> threads  = new ArrayList<>();

        for (var i=0; i < 10; i++){
            var thread = new Thread(new DownloadFileTask(status));
            thread.start();
            threads.add(thread);


        }

        for (var item:threads){
            try {
                item.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println(status.getTotalBytes());

    }
}
