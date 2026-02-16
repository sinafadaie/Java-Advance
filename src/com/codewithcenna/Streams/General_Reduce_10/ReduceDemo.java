package com.codewithcenna.Streams.General_Reduce_10;
import com.codewithcenna.Streams.Sorting_6.Movie;
import java.util.List;
import java.util.Optional;


//we can use reduce() to execute general purpose of reduction
//it is overloaded,but the most useful one is reduce(BinaryOperator)
public class ReduceDemo {
    public static void show(){
        List<Movie> movies = List.of(
                new Movie("a",10),
                new Movie("b",20),
                new Movie("c",30)
        );

        Optional<Integer> sum = movies.stream()
                .map(movie -> movie.getLikes())
                .reduce((a, b) -> a + b)      //execute one by one and return sum of the all likes
                ;                                           //its return an optional of Integer
                                                            //optional object, represent of an object that
                                                            //may or may not have a value(value is optional)


        System.out.println(sum.get());               //if the stream be empty, this got error
        System.out.println(sum.orElse(0));     //use orElse on Optional, return a default value

        //-------------------
        //we have sum method as a static method in Integer class
        sum = movies.stream()
                .map(movie -> movie.getLikes())
                .reduce((a,b)->Integer.sum(a,b));   //we cane use reference method

        //-------------------
        Integer reduce = movies.stream()                                  //we have overloaded reduce method that
                .map(movie -> movie.getLikes())                    //get default value if the value is empty(identity)
                .reduce(0, (a, b) -> a + b);       //it returns Integer, not the optional Integer
    }
}
