package com.codewithcenna.Lambda_Expresions.ChainingConsumers_8;

import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

//consumer interface has a default method **andThen**
//it's a default method, so this interface is still functional
//with this method we can chain consumers,its means we can run many operations in a sequence

public class ConsumerDemo {
    public static void show(){
        List<String> list = List.of("a","b","c");       //List is interface but has some static method like List.of()
                                                        //its returns a concrete object (some internal class) that implements List.
                                                        //So list refers to a real object, just not one whose class name you wrote.

        Consumer <String> print = item-> System.out.println(item);  //Consumer is a thing that created to consume something
                                                                          //in this case it suppose to consume String
                                                                          //we should implement accept method(we do it by lambda)
                                                                          //and lambda base on the Consumer type, knows it is a string

        Consumer <String> printUpperCase = item-> System.out.println(item.toUpperCase());    //we cant use method referencce here
                                                                                                   //toe method involved
        Consumer <String> printLowerCase = item-> System.out.println(item.toLowerCase());

        list.forEach(print);        //look at consumer like a black hole!
                                    //when you write a consumer, it just consume
                                    //consume and execute main method(accept method)

        print.accept(list.get(0));  //instead of call accept method and pass parameter to it like this line
                                    //its act like a suction and transfer to accept method


        list.forEach(print.andThen(printUpperCase).andThen(printLowerCase));    //look at this way
                                                                                //foreach create a thing to be consume in every loop(its input is consumer type)
                                                                                //print consume it "andThen" create a new hole and pass the thing to it
                                                                                //printUpperCase is in that hole and consume it too and so on...

        //-----under the hood!
        //control+click on method name = source code:

        /*default Consumer<T> andThen(Consumer<? super T> after) {
            Objects.requireNonNull(after);
            return (T t) -> { accept(t); after.accept(t); };
        }
        */

        //print.andThen(printUpperCase)                      so when we call like that
                                                            //its return a lambda expression
                                                            //a lambda that is a consumer object too
                                                            //so because of this return you have new hole
    }
}
