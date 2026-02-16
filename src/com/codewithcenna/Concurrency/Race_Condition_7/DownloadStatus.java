package com.codewithcenna.Concurrency.Race_Condition_7;

//thread1,tread2 come simultaneously
//they read totalBytes, its 0
//they increase it to 1
//they update totalBytes to 1 (2 update happened)
//but totalBytes should be 2 now
//this is race condition!
//it happened because of non-atomic operator

public class DownloadStatus {
    private int totalBytes;         //its 0 at first,because of default constructor

    public void incrementTotalBytes(){
        totalBytes++;               //this operator have multiple steps
    }                               //they are called non-atomic operator
                                    //at first read totalBytes value
                                    //then increase the value
                                    //and then update totalBytes


    public int getTotalBytes() {
        return totalBytes;
    }
}
