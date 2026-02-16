package com.codewithcenna.Concurrency.Adder_Clases_15;
import java.util.concurrent.atomic.LongAdder;

//Internally this long adder object keeps an array of counters
//that can grow on demand (aggregate when necessary),
//so we don't have a single place in memory where our value is stored
//we have a bunch of array cells, each holding a counter value
//so different threads can modify these counter variable concurrently
//that why they are faster than atomic class, they allow more throughput
//when we call intValue() method, internally its call another method (sum())
//witch is going to add up all these counter values and return result(and convert it to integer)
public class DownloadStatus {
    private LongAdder totalBytes = new LongAdder();

    public void incrementTotalBytes() {
          totalBytes.increment();
    }

    public int getTotalBytes() {
        return totalBytes.intValue();   //to return a normal integer
    }                                   //in LongAdder we have int,byte,short,....
}                                       //it call sum() method under the hood
