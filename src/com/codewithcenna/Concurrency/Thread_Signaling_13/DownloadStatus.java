package com.codewithcenna.Concurrency.Thread_Signaling_13;


public class DownloadStatus {
    private int totalBytes;
    private volatile boolean isDone = false;

    private Object totalBytesLock = new Object();

    public void incrementTotalBytes() {
        synchronized (totalBytesLock) {
            totalBytes++;
        }
    }

    public int getTotalBytes() {
        return totalBytes;
    }

    public  boolean getDone() {
        return isDone;
    }

    public  void Done() {
        isDone = true;
    }
}
