package com.codewithcenna.Exception.Catch_Multiple_Exception_5;

//we can have multiple catch type
//each related to specific exception
//the program will continue after catch block
//--------------------------
//the order of catch block some times be important
//now we're first writing FileNotFoundException, then write IOException
//but if we're first writing IOException then FileNotFoundException, we got error
//that's because the compiler check catch block **orderly**
//when you write IOException at first, the FileNotFoundException will catch there(it's because of polymorphism)
//that because the FileNotFoundException is child of IOException (search FileNotFoundException hierarchy)
//so you cant write blocks that catch same types, it's like case when
//--------------------------
//we can use " | " to treat like or in catch block
//It's for when we have same act for different exception type
//catch( IOException | ParseException ex){
//        System.out.println("could not read from data.");
//        }

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ExceptionDemo {
    public static void show(){
        try {
            var reader = new FileReader("file.txt");
            var value = reader.read();          //we need the exception, if we cant read from file
        }
        catch (FileNotFoundException ex) {

            System.out.println("File does not exist");
            System.out.println(ex.getMessage());
            ex.printStackTrace();

        }
        catch(IOException ex){
            System.out.println("could not read from data.");
        }
    }







































}
