package com.codewithcenna.Exception.Catching_Exception_4;

//create try/catch block with click on red lamp ---->surround with try/catch

import java.io.FileNotFoundException;
import java.io.FileReader;

public class ExceptionDemo {
    public static void show(){
        try {
            var reader = new FileReader("file.txt");
        } catch (FileNotFoundException ex) {      //in catch, we specify the type of exception
                                                  //name has convention, ex stand for exception
                                                  //ex object  is an instance of the FileNotFoundException
                                                  //it's an object that contains information about this exception

            System.out.println("File does not exist");
            System.out.println(ex.getMessage());  //this massage define in FileNotFoundException class
            ex.printStackTrace();                 //this show the stack trace
                                                  //it's wider than we saw in stack trace
                                                  //its print all the methods in standard java library
                                                  //they called from FileReader constructor
        }
    }


}
