package com.codewithcenna.Streams.Impretive_vs_Functional_1;
import java.util.List;

//paradigms:
//declarative/functional/oop/event-driven,...
//you maye use multiple paradigm in a single app
//--------
//stream is sequence of objects,but it does not store data
//it's just a way to get data out of a collection
//streams allow us to process a collection of objects
//in declarative or more accurately functional way
//as a metaphor, collection is water tank,stream is out pipeline

public class StreamDemo {
    public static void show(){
        List <Movie> movies = List.of(
                new Movie("a",10),
                new Movie("b",15),
                new Movie("c",20)
        );

    //this is imperative programing
    //specify how something should be done
        int count = 0;
        for (var item :movies){
            if(item.getLikes()>10)
                count++;
        }

    //this declarative programing(more accurately functional programing)
    //functional programing is kind of declarative programing
    //just said what to be done(the how is implemented in other place)
    //like Sql use order,where(SQL is a declarative language)


        var count2 = movies.stream()                                           //every collection has stream method
                 .filter(movie -> {return movie.getLikes()>10;})        //stream has methods that we can use in declarative way(filter,count,..)
                 .count();                                                    //filter get predicate obj(so we can use lambda)

    }

}
