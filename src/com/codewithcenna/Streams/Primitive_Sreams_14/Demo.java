package com.codewithcenna.Streams.Primitive_Sreams_14;

//if our stream is primitive type
//its so efficient to use primitive stream class(IntStream,LongStream,DoubleStream)
//if we use primitive where get object, we are paying boxing cost

import java.util.stream.IntStream;

public class Demo {
    public static void show(){

         IntStream.of(1,2,3,4)
                 .forEach(System.out::println);

         System.out.println("range: ");           //the upper bound is exclusive
         IntStream.range(1,5)
                 .forEach(System.out::println);


        System.out.println("rangeClosed: ");     //the upper bound is inclusive
        IntStream.rangeClosed(1,5)
                .forEach(System.out::println);
    }
}
