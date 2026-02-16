package com.codewithcenna.Streams.Grouping_Elements_12;
import java.util.List;
import java.util.stream.Collectors;

//we should use collect method on stream
//because we want to return data and store in a structure
//it returns **Map** (key:classifier,value:list of item in that group)
//-------
//Collectors.groupingBy is overloaded
//groupingBy(Function)
//groupingBy(Function , collector)
//-------
//with groupingBy(Function , collector)
//we can specify what do with collected values

public class GroupDemo {
    public static void show() {
        var movies = List.of(
                new Movie("a", 10, Genre.THRILLER),
                new Movie("c", 30, Genre.ACTION),
                new Movie("b", 20, Genre.ACTION)
        );

        var result = movies.stream()
                .collect(Collectors.groupingBy(movie -> movie.getGenre()));           //groupingBy get a function as a classifier,
                                                                                            //the function get movie object and return the attribute we want to group by
        System.out.println("value is list: " + result);                                     //look at the type of result(control+shift+p)
                                                                                            //Map<Genre , List<>movie>
                                                                                            //so if dont specify structure,the values store in a **List**

        var resultSet = movies.stream()
                .collect(Collectors.groupingBy(movie -> movie.getGenre(),
                        Collectors.toSet()));                                                //in another overloaded
                                                                                            //we can choose the structure of **value**
        System.out.println("value is set: " + resultSet);                                   //after classifier function, we can pass a collector like last lesson
                                                                                            //control+shift+p --> Map<Genre,Set<movie>>
        var resultCount = movies.stream()
                .collect(Collectors.groupingBy(movie -> movie.getGenre(),          //pass counting as collector
                        Collectors.counting()));                                         //collect the data, and return count
        System.out.println("value is count: " + resultCount);

        var resultJoin = movies.stream()
                .collect(Collectors.groupingBy(
                        movie -> movie.getGenre(),
                        Collectors.mapping(movie -> movie.getTitle(), Collectors.joining(","))   //we want pass joining as collector
                ));                                                                                             //but it executes only on string(context is movie)
                                                                                                                //instead of map the stream, we can map the object one by one
        System.out.println("value is joined: " + resultJoin);                                                   //with a Collectors.mapping(Function,collector)
                                                                                                                //lambda as map function,joining as collector
    }
}
