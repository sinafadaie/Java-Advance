package com.codewithcenna.Streams.Create_Stream_2;

//we can create a stream from
//Collections,
//Arrays,
//arbitrary number of objects
//infinite/finite streams
//its like query on collections
//method on streams usually act like query
//so streams write in declarative pattern like sql
//-----------------
//the object is going through stream is context of the stream
//it will penetrate to all lambdas,function,....

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;


public class StreamDemo {
    public static void show(){

        //-----------collection
        Collection<Integer> x = List.of(1,2,3);
        x.stream();             //every collection has stream method


        //-----------Arrays
        int[] numbers = {1,2,3};    //arrays have not stream method
                                    //but we can use Arrays class (utility class)
                                    //to get streams
        Arrays.stream(numbers)
                .forEach(n-> System.out.println(n));         //every stream has foreach method
                                                                 //it gets consumer(we can use lambda)

        //-----------Arbitrary numbers
        Stream.of(1,2,3);

        var infiniteNumbers = Stream.generate(()->{return Math.random();}) ;   //alter+enter->get Supplier (use lambda)
                                                                               //this create infinite stream of random numbers
                                                                               //we can not do this with collections, because we going to run out of memory
                                                                               //but in streams,its **lazy evaluation** (going to call when we want read a number)
                                                                               //we store it in a variable, the variable is empty now,it just a stream

        //infiniteNumbers.forEach(item-> System.out.println(item));       //but if a consumer,use it like this line
                                                                          //it will generate number for it until end of the world!
                                                                          //consumer request stream every time

        infiniteNumbers.limit(5)                                  //use a limit on stream
                .forEach(item-> System.out.println(item));


        Stream.iterate(1,n->n+1)   //iterator is another method we can generate infinite stream
                                                //it gets a seed(where we begin)
                                                //and then a unaryOperator(get a value,return a value)
                                                //it says begin from seed,then use unaryOperator on it
                                                //and use the return as seed ....(get infinite numbers)
                .limit(10)
                .forEach(item-> System.out.println(item));

    }
}
