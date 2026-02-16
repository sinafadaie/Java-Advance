package com.codewithcenna.Concurrency.Atomic_objects_14;
import java.util.concurrent.atomic.AtomicInteger;

//we write increment operation (totalBytes++)
//that was not an atomic operator (contain multiple operate inside itself)
//in an atomic way!
//-----------
//how compare and swap (CAS) works?
//Thread A:
//  Reads value = 5
//  Calculates newValue = 6
//  CAS: if (read) value is still 5 →  (check baseline,its passed)-->compare state
//  write 6                                                -->swap state
//-----------
//Thread B (at the same time):
//  Reads value = 5
//  Calculates newValue = 6
//  CAS: value has changed (now 6) ❌--->(check baseline,its failed,try again)
//  when comparing failed,we have no swap state
//-----------
//Thread B(Retries:)
//  reads value = 6
//  Calculates newValue = 7
//  CAS: if read value is still 6 (compare state)
//  write 7 (swap state)

public class DownloadStatus {
    private AtomicInteger totalBytes = new AtomicInteger( );

    public void incrementTotalBytes() {
          totalBytes.incrementAndGet();       //++totalBytes
          //totalBytes.getAndIncrement();     //totalBytes++
    }

    public int getTotalBytes() {
        return totalBytes.get();             //get return just a normal integer
    }
}
