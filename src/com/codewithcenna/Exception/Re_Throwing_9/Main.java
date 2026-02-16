package com.codewithcenna.Exception.Re_Throwing_9;
import java.io.IOException;



class Main {
   public static void main() {
       try {
           ExceptionDemo.show();
       }
       catch (Exception e) {  //parent of all exception object
           System.out.println("An unexpected error occurred");
       }
       catch (Throwable e) {  //parent of all exception and errors
                              //so every type of exception and error can catch here
                              //its more generic than above catch block
                              //its parent of exception class
                              //see hierarchy of exception
           System.out.println("An unexpected error occurred");
       }
   }
}
