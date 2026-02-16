package com.codewithcenna.Concurrency.Confinement_8_2;

import com.codewithcenna.Concurrency.Race_Condition_7.DownloadFileTask;
import com.codewithcenna.Concurrency.Race_Condition_7.DownloadStatus;
import java.util.ArrayList;
import java.util.List;

//in confinement, we will separate status object in each thread
//so they are not shared anymore
//--------
//when you create new instance in a loop with same name
//the object we created will remain in heap
//but in every iteration the address of new object write in variable
//so we loose the address of pre object!
//garbage collection come here.
//---------
//mosh create a list of DownloadFileTask instead of DownloadStatus
//and create private field with type of DownloadStatus and store them
//I think my code is better!

public class ThreadDemo {
    public static void show(){

        List<Thread> threads  = new ArrayList<>();
        List<DownloadStatus> statuses  = new ArrayList<>();

        for (var i=0; i < 10; i++){
            var status = new DownloadStatus();
            var thread = new Thread(new DownloadFileTask(status));
            thread.start();
            threads.add(thread);
            statuses.add(status);
        }



        for (var item:threads){
            try {
                item.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        var totalBytes = statuses.stream()
                        .map(status->status.getTotalBytes())
                                .reduce((a,b)->a+b);


        System.out.println(totalBytes);

    }
}
