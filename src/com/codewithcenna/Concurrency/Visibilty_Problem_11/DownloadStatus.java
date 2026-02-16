package com.codewithcenna.Concurrency.Visibilty_Problem_11;



public class DownloadStatus {
    private int totalBytes;
    private boolean isDone = false;

    private Object totalBytesLock = new Object();

    public void incrementTotalBytes() {
        synchronized (totalBytesLock) {
            totalBytes++;
        }
    }

    public int getTotalBytes() {
        return totalBytes;
    }

    public boolean getDone() {
        return isDone;
    }

    public void Done() {
        isDone = true;
    }
}
