package com.codewithcenna.Exception.Finally_Block_6;

//finally block will always get executed no matter what happened
//after try or after catch block
//its finally executed!
//----------------------
//when we open a file we should close it
//file handles are os resources,we should always release them
//we write close in final block to be sure always be executed
//we will release external resources like
//file handle, database connection,network connection in finally block
//if we close it in try block, its maybe will not execute
//if we close it catch block,we should write it twice
//if we write it after try/catch block, then maybe a developer add a new try catch block there
//and forget to handle our close


import java.io.FileReader;
import java.io.IOException;

public class ExceptionDemo {
    public static void show(){
        FileReader reader = null;   //to access reader out of try block we declare it here
                                    //the compiler should be sure if you use an object
                                    //before that you initial it
                                    //when you use close on reader object in try block, because of new
                                    //the compiler is sure
                                    //but when you use close in other place the compile get error
                                    //it said you should initiate the reader object
                                    //it's the reason we add **null**
        try {
            reader = new FileReader("file.txt"); //file is open now
            var value = reader.read();
            reader.close();
        }
        catch(IOException ex){                  //its cover both FileReader and read()
            System.out.println("could not read from data.");
        }
        finally {
            if (reader != null){
                try {
                    reader.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
