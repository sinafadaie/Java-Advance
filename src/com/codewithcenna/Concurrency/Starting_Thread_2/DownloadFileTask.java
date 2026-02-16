package com.codewithcenna.Concurrency.Starting_Thread_2;

public class DownloadFileTask implements Runnable{

    @Override
    public void run() {
        System.out.println("Downloading a file with :" + Thread.currentThread().getName());
    }
}
