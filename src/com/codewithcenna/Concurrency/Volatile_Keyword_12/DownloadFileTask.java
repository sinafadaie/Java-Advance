package com.codewithcenna.Concurrency.Volatile_Keyword_12;



public class DownloadFileTask implements Runnable{
    private DownloadStatus status;

    public DownloadFileTask(DownloadStatus status) {
        this.status = status;
    }

    @Override
    public void run() {
        System.out.println("Downloading a file with :" + Thread.currentThread().getName());

        for (var i=0;i<1_000_000;i++){
            if (Thread.currentThread().isInterrupted()) {
                break;
            }
            status.incrementTotalBytes();
        }

    }
}
