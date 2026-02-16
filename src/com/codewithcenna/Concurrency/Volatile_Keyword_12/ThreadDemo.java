package com.codewithcenna.Concurrency.Volatile_Keyword_12;

//for solve visibility problem
//we should enforce tread2 to update his cash from Ram
//(like what happened with writing System.out.println)
//------------
//we can use synchronized in get method(read DownloadStatus)
//or in better way we can use volatile keyword (best practice)
//------------
//if we use volatile on a field
//we can solve visibility problem (not racing problem!)
//we say to jvm, its unstable field
//don't catch it, always read it from Ram!
//(if hase change, write it to ram immediately)
//this is best practice for visibility problem

public class ThreadDemo {
    public static void show(){

        var status = new DownloadStatus();

        var thread1 = new Thread(new DownloadFileTask(status));

        var thread2 = new Thread(()->{
            while (!status.getDone()){
               // System.out.println("its not Done yet!");
            }
            System.out.println("its Done!");
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        status.Done();
        System.out.println(status.getTotalBytes());

    }
}
