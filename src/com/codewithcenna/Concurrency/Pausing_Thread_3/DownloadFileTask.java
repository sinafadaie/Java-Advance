package com.codewithcenna.Concurrency.Pausing_Thread_3;

public class DownloadFileTask implements Runnable{
    @Override
    public void run() {
        System.out.println("Downloading a file with :" + Thread.currentThread().getName());

        try {
            Thread.sleep(5000);              //sleep is a static method that stop current thread (the thread that execute it)
        } catch (InterruptedException e) {         //its paused about 5 second (it is a little different in various os)
            throw new RuntimeException(e);         //when another thread is interrupting sleeping thread InterruptedException is throws
        }

        System.out.println("Download is complete : " + Thread.currentThread().getName());
    }
}
