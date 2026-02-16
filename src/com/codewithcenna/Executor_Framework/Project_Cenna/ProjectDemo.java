package com.codewithcenna.Executor_Framework.Project_Cenna;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class ProjectDemo {
    public static void show(){



        CompletableFuture<String> quoteSite1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Getting a quote from site1");
            RandomDelay.randomDelay();
            return "Quote{site='site1', price=100}";
        });

        CompletableFuture<String> quoteSite2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Getting a quote from site2");
            RandomDelay.randomDelay();
            return "Quote{site='site2', price=105}";
        });

        CompletableFuture<String> quoteSite3 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Getting a quote from site3");
            RandomDelay.randomDelay();
            return "Quote{site='site3', price=108}";
        });

        quoteSite1.thenAccept((quote)-> System.out.println(quote));
        quoteSite2.thenAccept((quote)-> System.out.println(quote));
        quoteSite3.thenAccept((quote)-> System.out.println(quote));

        try {                                                                               //block main thread here!
            CompletableFuture.allOf(quoteSite1, quoteSite2, quoteSite3)                     //otherwise we cant see result in terminal
                    .get();
            System.out.println("Retrieved all quotes in " + RandomDelay.getAllDelay() + "msec");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }


    }
}
