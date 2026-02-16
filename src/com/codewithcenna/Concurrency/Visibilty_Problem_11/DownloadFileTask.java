package com.codewithcenna.Concurrency.Visibilty_Problem_11;


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
