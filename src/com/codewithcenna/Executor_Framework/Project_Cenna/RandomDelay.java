package com.codewithcenna.Executor_Framework.Project_Cenna;
import java.util.concurrent.atomic.AtomicInteger;
import static java.lang.Math.*;

public class RandomDelay {
    private static AtomicInteger allDelay = new AtomicInteger();

    public static void randomDelay(){
        var time =  (int) (random()*10000);
        try {
            Thread.sleep(time);
            allDelay.accumulateAndGet(time,(a,b)->{return a+b;});
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static int getAllDelay() {
        return allDelay.intValue();
    }
}
