package com.codewithcenna.Concurrency.Interrupting_Thread_5;

//sometimes in long-lived tasks
//we want to give our users the ability to cancel
//-------
//if a thread is interrupted
//we cant pause it anymore
//that why we should handle InterruptedException when pausing a thread
public class ThreadDemo {
    public static void show(){

        System.out.println(Thread.currentThread().getName());

        Thread thread1 =new Thread(new DownloadFileTask());
        thread1.start();

        try {
            Thread.sleep(4000);            //main thread is paused for 4 second
        } catch (InterruptedException e) {       //and the other thread is printing!
            throw new RuntimeException(e);
        }

        thread1.interrupt();                     //it's just a flag (field of thread1)
                                                 //if we don't implement logic on it,its do nothing
                                                 //it's not force the thread to stop!

        System.out.println("we terminate thread1 after 4 socond!");
    }
}
