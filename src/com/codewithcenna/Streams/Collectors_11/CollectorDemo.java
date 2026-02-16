package com.codewithcenna.Streams.Collectors_11;

//we used to consume the stream with foreach until now
//but we can collect the stream in a data structure
//it return a collection object
//the type of collection returned is depend on the collect argument
//collect() method is over loaded but the useful one get a **collector object**
//------
//so many method return collectors object
//but the best way use **Collectors class**-->utility class
//Collectors is a utility class with static factory methods
//with which you can create common Collector implementations.
//So Collectors is not an implementation, but the return value of Collectors.
//---------******
//see the collector object as an object that collect data
//and do something on it
//mabe put it in a structure(list,map,set,...)
//mabe count it
//mabe summerized it
//mabe join it
//....

import com.codewithcenna.Streams.Sorting_6.Movie;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CollectorDemo {
    public static void show(){
        List<Movie> movies = List.of(
                new Movie("a",10),
                new Movie("b",20),
                new Movie("c",30)
        );

        var result = movies.stream()
                .filter(movie -> movie.getLikes()>10)
                .collect(Collectors.toList()) ;  //toList method return a collector interface(collect want collector type)
                                                 //that know how to convert a string to a list
                                                 //with this, we say put item come from stream in a List

        System.out.println(result);             //its a list of movie
        System.out.println(result.get(0).getLikes());

        var resultSet = movies.stream()         //set of movies
                .filter(movie -> movie.getLikes()>10)
                .collect(Collectors.toSet()) ;

        //create hash map
        //key(title),value(likes)

        System.out.println("HashMap: ");

        var resultMap = movies.stream()
                .filter(movie -> movie.getLikes()>10)
                .collect(Collectors.toMap(movie -> movie.getTitle(),     //to map get tow function type(keyMapper,valueMapper)
                                          movie -> movie.getLikes()));   //as argument
                                                                               //****** we say from context (stream),movie objects come *******
                                                                               //first function,get the movie obj as argument and return title
                                                                               //second function, get the movie obj as argument and return likes
        System.out.println(resultMap);

        //key(title),value(movie obj)
        movies.stream()
                .filter(movie -> movie.getLikes()>10)
                .collect(Collectors.toMap(movie -> movie.getTitle(),
                                          movie -> movie)               //we have function that get movie obj
                                                                              // and return movie obj
                );                                                            //but it is wierd! we have method for that

        var resultMap2=movies.stream()
                .filter(movie -> movie.getLikes()>10)
                .collect(Collectors.toMap(movie -> movie.getTitle(),
                                          Function.identity())               //Function interface has a static method called identity()
                );                                                           //return the argument,we can use it here
        System.out.println("value is entire obj : " + resultMap2);

        //-----------------------------

        var sumLikes = movies.stream()
                .filter(movie -> movie.getLikes()>10)
                .collect(Collectors.summingInt(movie-> movie.getLikes()));       //control+p-->get a toIntFunction
                                                                                       //its another way to sum likes


        IntSummaryStatistics summary = movies.stream()                                 //get summary of likes
                .filter(movie -> movie.getLikes() > 10)
                .collect(Collectors.summarizingInt(movie -> movie.getLikes()));
        System.out.println(summary);

        //------------------------------
        //join values

        var names = movies.stream()                                               //names type is String
                .filter(movie -> movie.getLikes() > 10)
                .map(movie -> movie.getTitle())
                .collect(Collectors.joining(","));                       //joining execute on strings
                                                                                 //so if our stream is string
                                                                                 //we can combine them by joining
        System.out.println(names);
    }
}
