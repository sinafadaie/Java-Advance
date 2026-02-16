package com.codewithcenna.Executor_Framework.Callable_and_Futures_3;

public class LongTask {
    public static void simulate(){
        try {
            Thread.sleep(5000);             //every thread come here
        } catch (InterruptedException e) {        //freeze for 5 second
            throw new RuntimeException(e);
        }
    }

    public static void simulate(int delay){      //make it over load
        try {                                    //for final project
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
