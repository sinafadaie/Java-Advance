package com.codewithcenna.Concurrency.Synchronised_Keyword_10;

//we create synchronized block, instead locking
//synchronized get monitor object
//every object in java has a builtin log and use it under the hood
//pass "this" as reference of current object is bad practice
//its lock every method that use synchronized in this class
//(if we have another method like incrementTotalFile,
//and it has synchronized (this) to
//if a thread wants to use one of the method, the other method locks too(because both of them use same monitor object)
//but locking the other method of this object is redundant)
//so it make over head in large application, put unnecessary weight
//--------------------
//in best practice we should use dedicated monitor objects
//every object has own lock inside
//when we use "this" as monitor object, we use current object lock
//so when a thread comes, we lock the current object totally, so the other methods will lock too
//but if we use another object lock,we can lock some piece of our current object
//the piece that we really want to lock,not the whole object!
//--------------------
//actually as best practice you should not use Synchronization
//it's not good, its creates bugs
//you should use other technics instead

public class DownloadStatus {
    private int totalBytes;
    private int totalFiles;

    private Object totalBytesLock = new Object();   //dedicated monitor objects
    private Object totalFilesLock = new Object();   //they can be any type, but in convention, we create plane Object class
                                                    //because we are not looking for any specific behavior


    public void incrementTotalBytes2() {

        synchronized (this) {         //we create synchronized block, instead locking
            totalBytes++;             //this is bad practice
        }
    }

    public synchronized void incrementTotalBytes3() {   //we can use synchronized in defining of method
            totalBytes++;                               //it put all the body in a synchronized block
    }                                                   //but it passes "this" as monitor object automatically
                                                        //so its bad practice too

    public void incrementTotalBytes() {     //in this way,when a thread using this method
        synchronized (totalBytesLock){      //we just lock this method
            totalBytes++;
        }
    }

    public void incrementTotalFiles() {
        synchronized (totalFilesLock){
            totalFiles++;
        }
    }

    public int getTotalBytes() {
        return totalBytes;
    }
}
