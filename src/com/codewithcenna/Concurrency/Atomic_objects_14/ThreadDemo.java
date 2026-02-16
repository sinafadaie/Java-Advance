package com.codewithcenna.Concurrency.Atomic_objects_14;
import java.util.ArrayList;
import java.util.List;

//another strategy for thread safety is using Atomic classes like
//AtomicBooleans,AtomicInteger,...
//with these classes, we can perform atomic operations!
//-------------
//they actually use a technique called **compare & swap** (CAS)
//witch is supported by most cpu,
//cpu can execute this operation as a single uninterruptible operation
//-------------
//when you are dealing with "counter variable" like TotalBytes
//using "Atomic Objects" is best practice
//they are safe and fast

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
