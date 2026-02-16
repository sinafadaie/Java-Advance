package com.codewithcenna.Streams.Peek_8;
import com.codewithcenna.Streams.Sorting_6.Movie;
import java.util.List;

//in large query we need tool for debug
//with peek we can see middle of the stream
//peek is exactly like foreach
//get a predicate as argument
//and execute one by one
//for each return void, so we could not use foreach,it cuts the stream
//but the peek return pre stream
//-----
//look at the terminal
//its like every item pass the stream one by one

public class PeekDemo {
    public static void show(){
        var movies = List.of(
                new Movie("a", 10),
                new Movie("c", 30),
                new Movie("b", 20)
        );

        movies.stream()
                .filter(movie -> movie.getLikes()>10)
                .peek(movie->System.out.println("more than 10: " + movie))
                .map(movie -> movie.getTitle())
                .peek(title-> System.out.println("title: " + title))
                .forEach(System.out::println);
    }
}
