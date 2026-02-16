package com.codewithcenna.Concurrency.Race_Condition_7;

public class DownloadFileTask implements Runnable{
    private DownloadStatus status;

    public DownloadFileTask(DownloadStatus status) {
        this.status = status;
    }

    @Override
    public void run() {
        System.out.println("Downloading a file with :" + Thread.currentThread().getName());

        for (var i=0;i<10_000;i++){                         //assume each file is 10000 bytes
            if (Thread.currentThread().isInterrupted()) {
                break;
            }
            status.incrementTotalBytes();                  //here is the race!
        }

    }
}
