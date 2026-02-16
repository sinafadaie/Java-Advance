package com.codewithcenna.Concurrency.Interrupting_Thread_5;

public class DownloadFileTask implements Runnable{
    @Override
    public void run() {
        System.out.println("Downloading a file with :" + Thread.currentThread().getName());

        for (var i=0;i<Integer.MAX_VALUE;i++){              //instead of simulating download time with sleep
            if (Thread.currentThread().isInterrupted()) {   //MAX_VALUE is end of the world!
                break;
            }
            System.out.println("Downloading byte " + i );
        }

    }
}
