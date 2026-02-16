package com.codewithcenna.Concurrency.Joining_Thread_4;
import com.codewithcenna.Concurrency.Pausing_Thread_3.DownloadFileTask;


//after downloading a file
//we want to scan it for viruses
//but we have to be sure, the file is downloaded completely
//--------
//with join method, we tell current method
//to wait for the completion of another thread


public class ThreadDemo {
    public static void show(){

        System.out.println(Thread.currentThread().getName());

        Thread thread1 =new Thread(new DownloadFileTask());
        thread1.start();

        try {
            thread1.join();                     //main thread execute this
        } catch (InterruptedException e) {      //so we pause the main thread with this line
            throw new RuntimeException(e);      //until the thread1 is done
        }                                       //it get InterruptedException too
                                                //because it acts like sleep,main thread is sleep for *unknown time*
        System.out.println("see me with 5 second delay!  ");
    }
}
