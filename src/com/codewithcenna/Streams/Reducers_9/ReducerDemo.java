package com.codewithcenna.Streams.Reducers_9;

//reducers look at all the streams, and return just single object
//it can be a number or the object transfer the stream
//count()
//anyMatch(predicate) / allMatch(predicate) / noneMatch(predicate) -->(all of them return boolean)
//findFirst() / findAny()
//max(comparator) / min(comparator)
//----------
//all the reducers are terminal operator
//and they will cut the stream


import com.codewithcenna.Streams.Sorting_6.Movie;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class ReducerDemo {
    public static void show(){

        List <Movie> movies = List.of(
                new Movie("a",10),
                new Movie("b",20),
                new Movie("c",30)
        );

        long count = movies.stream()
                .count();
        System.out.println("count: " + count);

        boolean anyMatch = movies.stream()                            //matches return boolean
                .anyMatch(movie -> movie.getLikes() > 10);      //is there any movie above 10? true

        boolean allMatch = movies.stream()                            //is all movies under the 40? true
                .allMatch(movie -> movie.getLikes() < 40);

        boolean noneMatch = movies.stream()                          //none of the movie under 40? false
                .noneMatch(movie -> movie.getLikes() < 40);

        //---------

        Movie movie = movies.stream()      //return first object of the stream
                .findFirst()               //no argument,return optional(talk about optional later)
                .get();                    //but it prevents null pointer exception
        System.out.println();              //when reducer return object
                                           //use get to catch optional
        System.out.println(movie);

        movie = movies.stream()
                .findAny()
                .get();
        System.out.println(movie);

        //---------
        /*Optional<Movie> max = movies.stream()
                .max(item -> item.getLikes());            //we used a movie class version that is not comparable
        System.out.println(max);                          //so it got error
                                                          //we can pass comparator using Comparator.comparing()
         */

        Movie max = movies.stream()            //max return context(the movie obj, not the likes )
                .max(Comparator.comparing(movie1 -> movie1.getLikes()))
                .get();

        System.out.println(max);
    }
}
