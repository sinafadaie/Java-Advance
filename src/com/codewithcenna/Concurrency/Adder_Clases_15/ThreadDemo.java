package com.codewithcenna.Concurrency.Adder_Clases_15;
import java.util.ArrayList;
import java.util.List;

//atomic object is ideal for counter variable
//but if multiple threads updating a value frequently
//its better using adder classes, it's faster than atomic objects
//when updating a value frequently,CAS (compare and swap) fail more in atomic objects
//so it get slower and slower!
//but adder class says:
//بیاین دعوا نکنیم، هرکی بره یه گوشه بشمره!
//its usually define an array, and specify each cell to separate threads
//we have just two Adder class
//LongAdder
//DoubleAdder


public class ThreadDemo {
    public static void show(){

        var status = new DownloadStatus();
        List<Thread> threads  = new ArrayList<>();

        for (var i=0; i < 10; i++){
            var thread = new Thread(new DownloadFileTask(status));
            thread.start();
            threads.add(thread);
        }

        for (var item:threads){
            try {
                item.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println(status.getTotalBytes());

    }
}
