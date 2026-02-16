package com.codewithcenna.Streams.Partitioning_Elements_13;
import com.codewithcenna.Streams.Grouping_Elements_12.Genre;
import com.codewithcenna.Streams.Grouping_Elements_12.Movie;
import java.util.List;
import java.util.stream.Collectors;

//we want partition movies in tow category
//more than 20 likes,less tha 20 like
//we use partitioningBy collector
//----------
//overload just get predicate
//partitioningBy(predicate)
//it return Map<boolean,List<obj>>
//----------
//overload with downstream collector:
//partitioningBy(predicate,collector)
//Map<boolean, ?<obj>> (? is structure we passed by collector)

public class PartitionDemo {
    public static void show() {
        var movies = List.of(
                new Movie("a", 10, Genre.THRILLER),
                new Movie("c", 30, Genre.ACTION),
                new Movie("b", 20, Genre.ACTION)
        );

        var result = movies.stream()
                .collect(Collectors.partitioningBy(movie -> movie.getLikes()>20));
        System.out.println("values are list: " + result);

        var resultSet = movies.stream()
                .collect(Collectors.partitioningBy(movie -> movie.getLikes()>20,
                                                    Collectors.toSet()));               //use a collector to modify value structure
                                                                                        //Map<boolean,set<movie>>
        System.out.println("value are set: " + resultSet);

        var resultJoin = movies.stream()
                .collect(Collectors.partitioningBy(movie -> movie.getLikes()>20,
                        Collectors.mapping(movie -> movie.getTitle(),Collectors.joining("/"))
                ));
        System.out.println("values separate by '/' : " + resultJoin);


    }
}
