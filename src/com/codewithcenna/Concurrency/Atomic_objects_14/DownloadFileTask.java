package com.codewithcenna.Concurrency.Atomic_objects_14;


public class DownloadFileTask implements Runnable{
    private DownloadStatus status;

    public DownloadFileTask(DownloadStatus status) {
        this.status = status;
    }

    @Override
    public void run() {
        System.out.println("Downloading a file with :" + Thread.currentThread().getName());

        for (var i=0;i<10_000;i++){
            if (Thread.currentThread().isInterrupted()) {
                break;
            }
            status.incrementTotalBytes();
        }

    }
}
