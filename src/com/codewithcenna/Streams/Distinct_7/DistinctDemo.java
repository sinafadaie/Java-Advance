package com.codewithcenna.Streams.Distinct_7;

import com.codewithcenna.Streams.Sorting_6.Movie;

import java.util.List;

public class DistinctDemo {
    public static void show(){
        var movies = List.of(
                new Movie("a", 10),
                new Movie("a", 10),
                new Movie("c", 20),
                new Movie("b", 30)
        );

        movies.stream()                                 //stream of movie
                .map(movie -> movie.getLikes())   //stream of likes
                .distinct()
                .forEach(System.out::println);

    }
}
