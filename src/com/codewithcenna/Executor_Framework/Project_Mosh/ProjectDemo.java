package com.codewithcenna.Executor_Framework.Project_Mosh;

import java.time.Duration;
import java.time.LocalTime;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class ProjectDemo {
    public static void show(){

        var start = LocalTime.now();

        var service = new FlightService();
        List<CompletableFuture<Void>> futures = service.getQuotes()
                .stream()                        //we can return stream<List<CompletableFuture<Quote>>>
                                                 //instead of List<CompletableFuture<Quote>> in getQuotes()
                                                 //in that way we don't need to convert it twice
                .map(future -> future.thenAccept(System.out::println))
                .collect(Collectors.toList());   //we just call a terminal operation to start the stream!
                                                 //if we don't write it nothing happened

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))   //we can pass Array instead varargs!
                                                                             //with this 0 we just specify that
                                                                             //its array of CompletableFuture
                .thenRun(()->{
                    var end = LocalTime.now();
                    var duration = Duration.between(start,end);
                    System.out.println("Retrieved all quotes in " + duration.toMillis() + "msec");
                });



        try {                                   //we need delay
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
