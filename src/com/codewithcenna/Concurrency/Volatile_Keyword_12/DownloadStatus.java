package com.codewithcenna.Concurrency.Volatile_Keyword_12;

//synchronized creates a memory barrier.
//That means:
//Before entering the method, the thread refreshes its cache
//It reads isDone from main memory, not a stale cached value
//----------------
//if we use /*synchronized*/ in getter
//visibility problem will solve
//but its lock whole the current object
//its bad solution(don't use it)

public class DownloadStatus {
    private int totalBytes;
    private volatile boolean isDone = false;        //used volatile

    private Object totalBytesLock = new Object();

    public void incrementTotalBytes() {
        synchronized (totalBytesLock) {
            totalBytes++;
        }
    }

    public int getTotalBytes() {
        return totalBytes;
    }

    public /*synchronized*/ boolean getDone() {     //so if we synchronized the method
        return isDone;                              //when thread2 call getDone
    }                                               //its get value from Ram

    public /*synchronized*/ void Done() {
        isDone = true;
    }
}
