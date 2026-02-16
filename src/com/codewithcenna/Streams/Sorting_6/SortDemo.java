package com.codewithcenna.Streams.Sorting_6;
import java.util.Comparator;
import java.util.List;

//in default, order of the stream,is the order of the base source
//------
//sorted()               --> like comparable(don't get anything,based on comparing two object)
//sorted(Comparator obj) --> like comparator(specify what should be compare)
//------
//Comparator interface is a functional interface
//in past we create a separate class to implement comparator(like emailSort)
//but we can use lambda to create our comparator object(implement compareTo method)
//------
//in past we said that lambda act like interface instance
//but it better to say, we can create object from interface with help of that lambda
//where ever we saw a functional interface **type** (parameter type,return type,variable type)
//we can use that type by implement abstract method by lambda
//------
//look at Comparator.comparing as declarative way
//you just get to it,what you want sorting by

public class SortDemo {
    public static void show() {
        var movies = List.of(
                new Movie("a", 10),
                new Movie("c", 30),
                new Movie("b", 20)
        );

        System.out.println("default sort:");
        movies.stream().
                forEach(item-> System.out.println(item.getTitle()));        //order of source

        System.out.println("-----");

        movies.stream()                         //sorted method is overloaded
                .sorted()                       //when get nothing, its sorting based on object
                .forEach(System.out::println);  //so in this case our object should be comparable(the class should be extended to comparable interface)
                                                //so we got error(our object is not comparable)--->we fixed it
                                                //now the movie class implement comparable interface
                                                //now if two movie object compared to each other,they compared based on their title



        System.out.println("sort based on likes:");         //comparator interface has just abstract compare(T o1,T o2) method
        movies.stream()                                     //we use lambda to implement it
                .sorted((movie1,movie2)-> {return movie1.getLikes()-movie2.getLikes();})
                .forEach(System.out::println);


        System.out.println("------");

        movies.stream()
                .sorted(Comparator.comparing((Movie m)->m.getLikes()))           //in pre lambda was gray
                .forEach(System.out::println);                                   //it says you don't need to implement compare method
                                                                                 //sorted get a comparator, and comparator interface has a static method that return it
                                                                                 //(create comparator object)
                                                                                 //comparing(Function<? super T,? extend U>)
                                                                                 //---------
                                                                                 //this method get a function(a functional interface)
                                                                                 //so we can use lambda to implement **apply()**

        System.out.println("reversed:");                                         //comparator object has reversed() method
        movies.stream()                                                          //Comparator.comparing() return a comparator
                .sorted(Comparator.comparing(Movie::getLikes).reversed())
                .forEach(System.out::println);

    }
}
