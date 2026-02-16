package com.codewithcenna.Concurrency.Race_Condition_7;

import java.util.ArrayList;
import java.util.List;

public class ThreadDemo {
    public static void show(){

        var status = new DownloadStatus();
        List<Thread> threads  = new ArrayList<>();

        for (var i=0; i < 10; i++){
            var thread = new Thread(new DownloadFileTask(status));  //status object is shared!
            thread.start();                                         //we just create one status obj
            threads.add(thread);                                    //but 10 threads modify it

            //item.join                                               if we use join here, we are preventing main to create
        }                                                           //multiple threads, they are creating sequentially



        for (var item:threads){                         //when we want to check multiple threads were done
            try {                                       //we should use List
                item.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println(status.getTotalBytes());     //now we know all threads is done
                                                        //we expect 100_000 but it's not!
    }                                                   //it's lower than 100_000
}
