package com.codewithcenna.Concurrency.Locks_9;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//as best practice
//we should execute unlock() in a finally block
//because if an exception is thrown,we don't want to keep this lock forever
//if the unlock() don't execute, other threads never allowed to enter critical section
//our app can crash

public class DownloadStatus {
    private int totalBytes;
    private Lock lock = new ReentrantLock();    //ReentrantLock is one implementation
                                                //of Lock Interface
    public void incrementTotalBytes() {

        lock.lock();            //our lock begin, it holds thread here
        //and pass them one by one
        try {
            totalBytes++;
        }
        finally {                   //use finally,to be sure always unlock() will executed
            lock.unlock();          //it said, pre thread pass the critical section
        }                           //and the next thread enter the critical section
    }


    public int getTotalBytes() {
        return totalBytes;
    }
}
