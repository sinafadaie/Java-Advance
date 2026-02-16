package com.codewithcenna.Executor_Framework.Project_Mosh;
import com.codewithcenna.Executor_Framework.Callable_and_Futures_3.LongTask;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class FlightService {

    public CompletableFuture<Quote> getQuote(String site){          //it simulates an API
        return CompletableFuture.supplyAsync(()->{                  //we pass name of site
                System.out.println("Getting a quote from " + site); //its return a quote(that have price)
                                                                    //we use **Supply**
                var random = new Random();                          //but use site name inside!
                var price = 100 + random.nextInt(10);
                LongTask.simulate(1_000+random.nextInt(2_000));
                return new Quote(site,price);
        });
    }

    public List<CompletableFuture<Quote>> getQuotes(){

        List<String> sites = List.of("site1","site2","site3");
        /* this is functional pattern:
        List<CompletableFuture<Quote>> quotes = new ArrayList<>();
        for (var site : sites){
            quotes.add(getQuote(site));
        }
        return quotes;*/

        return sites.stream()                       //declarative pattern
                .map(site->{return getQuote(site);})
                .collect(Collectors.toList());
    }
}
