package com.codewithcenna.Exception.Try_With_Resource_Statement_7;

//best practice is to use resource statement
//java have specific way for release external resources
//instead of write that ugly finally block!
//we can declare and initialize our external resources
//as part of the try statement.
//add brace front of try! done
//in this way java will close file itself!
//will close every thing we declare there
//its call resource statement in try block
//---------------------
//search FileReader class, its implemented a interface named AuotoCloseable
//close method define in that interface
//its do that for us

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ExceptionDemo {
    public static void show(){

        try (
            var reader = new FileReader("file.txt");  //we can create multiple object here like below
            //var writer = new FileWriter("...")
        ){

            var value = reader.read();
            reader.close();                      //its make it gray!, we dont need it anymore
        }
        catch(IOException ex){
            System.out.println("could not read from data.");
        }
    }
}
