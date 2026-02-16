package com.codewithcenna.Streams.Slicing_5;

//we have some method for slicing streams
//limit(n)
//skip(n)
//takeWhile(predicate) -->as long as true,it transfers the stream
//dropWhile(predicate) -->as long as true,it skips the item, when turn false, transfer rest of the stream
//-----
//we can use skip for pagination
//we have 1000 movies,10 movies per page
//we want see 3rd page
//skip( (page - 1) * pageSize) = skip(20)
//limit(10)  to just get 3rd page

import com.codewithcenna.Streams.Impretive_vs_Functional_1.Movie;
import java.util.List;

public class SliceDemo {
    public static void show(){
        var movies = List.of(
                new Movie("a",10),
                new Movie("b",30),
                new Movie("c",20)
        );

        movies.stream()
                .limit(2)
                .forEach(movie-> System.out.println(movie.getTitle()));

        //----skip
        System.out.println("----");
        movies.stream()
                .skip(2)    //skip tow first element
                .forEach(movie-> System.out.println(movie.getTitle()));  //just print c

        //----takeWhile
        System.out.println("----");
        movies.stream()
                .takeWhile(movie -> {return movie.getLikes()<30 ;})      //although we have two movie under 30
                .forEach(item-> System.out.println(item.getTitle()));    //it just shows one of them
                                                                               //its see false and cut the stream(its not used for filtering!)

        //----dropWhile
        System.out.println("----");
        movies.stream()
                .dropWhile(movie -> {return movie.getLikes()<30 ;})     //skip first(because its true)
                .forEach(item-> System.out.println(item.getTitle()));   //but in second element,it turns false
                                                                              //so it print all of the remaining elements(b,c)

    }
}
