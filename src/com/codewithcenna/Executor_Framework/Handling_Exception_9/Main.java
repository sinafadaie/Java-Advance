package com.codewithcenna.Executor_Framework.Handling_Exception_9;
//Important rule for reading a stack trace:
//Start from the lowest Caused by.
//That is the original root cause of the error.
//Everything above it is usually just wrapping (re-throwing) the original exception.
//The top line does not mean the first error.
//It means the last exception that was thrown (the outermost wrapper).




public class Main {
    public static void main(){

        CompletableFutureDemo.show();   //we haven't any exception here

        CompletableFutureDemo.show2();  //we have exception here(in main thread)!
                                        //RuntimeException: java.util.concurrent.ExecutionException: java.lang.IllegalStateException
                                        //we have a run time exception ,its cause is a ExecutionException
                                        //and cause of the ExecutionException is our IllegalStateException
                                        //notice that the red lines is not for error (Process finished with exit code 0)
                                        //It's for e.printStackTrace();
    }
}
