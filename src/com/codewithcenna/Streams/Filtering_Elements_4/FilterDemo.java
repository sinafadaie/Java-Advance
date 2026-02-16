package com.codewithcenna.Streams.Filtering_Elements_4;
import com.codewithcenna.Streams.Impretive_vs_Functional_1.Movie;
import java.util.List;
import java.util.function.Predicate;

//stream methods fall into two categories
//intermediate operations (return new streams) like filter,map,..
//terminal operations (return void) like foreach
//-----
//if we dont call any terminal operation in a stream
//our stream does not start, its empty, ita lazy!
//it just a recipe


public class FilterDemo {
    public static void show(){

        var movies = List.of(
                new Movie("a",10),
                new Movie("b",20),
                new Movie("c",30)
        );

        Predicate <Movie> popularMovie = movie -> {return movie.getLikes()>10;};

        movies.stream()
                .filter(popularMovie)         //look at what filter return? a stream
                .forEach(item-> System.out.println(item));
    }
}
