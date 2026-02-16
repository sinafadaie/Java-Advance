package com.codewithcenna.Streams.Mapping_Elements_3;

//sometimes we need map our element in a stream
//use map(),flatMap()
//----
//map has primitive variant(mapToInt,mapToDouble,...)
//in mapToInt the function that get an input should return Integer
//----
//if we have a composite stream, and we want flat the stream
//we can use flatMap method to get a stream based on sub item
//like we have stream of (list of numbers),we want stream of numbers


import com.codewithcenna.Streams.Impretive_vs_Functional_1.Movie;

import java.util.List;
import java.util.stream.Stream;

public class MapDemo {

    public static void show(){
        var movies = List.of(
                new Movie("a",10),
                new Movie("b",20),
                new Movie("c",30)
        );

        //instead of stream of movies object
        //we want stream of movies name

        movies.stream()
                .map(movie -> {return movie.getTitle();})        //alter+enter->map get a function(so we can use lambda for apply)
                                                                       //its get a value(movie object and return movie name)

                .forEach(item-> System.out.println(item));      //foreach recognize that,its a String stream
                                                                      //but we began from movie object stream
                                                                      //look at this way,they are separate pipeline that attach together
                                                                      //and pass the stream one by one

        //----flatmap

        List list1 = List.of(1,2,3);
        List list2 = List.of(4,5,6);
        List tList= List.of(list1,list2);
        tList.stream()
                .forEach(item-> System.out.println(item));

        Stream.of(List.of(1,2,3),List.of(4,5,6))   //better way to create this stream

                .flatMap(list->{return list.stream();})               //get each item,and create a new stream on it
                                                                                  //how? with a function(use lambda) that get a list of integer and return stream
                .forEach(item-> System.out.println(item));

    }
}
