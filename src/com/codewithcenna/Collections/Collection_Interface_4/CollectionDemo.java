package com.codewithcenna.Collections.Collection_Interface_4;

//control+p-->we can see parameter of a method
//------------------------
//ArrayList <String> collection = new ArrayList<>() :
//An object of type ArrayList is created in the heap.
//However, the variable collection is declared as type Collection.
//That means the reference type is Collection
//Because of that, only the methods defined in Collection are accessible.
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class CollectionDemo {
    public static void show(){
        Collection <String> collection = new ArrayList<>(); //Arraylist class implement collection interface
                                                            //so arraylist object is a collection

        //ArrayList <String> collection = new ArrayList<>(); if we write this,we access to all collection and arraylist methods
                                                            //but now we just access to collection method(not the arraylist methods)
                                                            //so our code is very flexible now
                                                            //we can switch to another structure like link list without any change to rest of the code
                                                            //conceder that if we use **var** its create ArrayList
        collection.add("a");
        collection.add("b");
        collection.add("c");
        System.out.println(collection); //print entire collection

        for(var item:collection){       //collection extended to iterable,so we can use for each
            System.out.println(item);
        }

        Collections.addAll(collection,"d","e","f");   //if we want addAll at once, use Collections class(has s)
                                                                //control+p-->we can see parameter
                                                                //String...-->means you can pass a variable number of argument
        System.out.println(collection);
        System.out.println(collection.size());                 //length of collection
        collection.remove("b");                             //not the index, the value we want to remove
        System.out.println(collection);
        System.out.println(collection.contains("c"));          //exist of an element
        collection.clear();                                    //clear whole collection
        System.out.println(collection.isEmpty());

        //----------comparing
        Collections.addAll(collection,"d","e","f");
        Collection<String> otherCollection = new ArrayList<>();

        otherCollection.addAll(collection);     //its different from pre addAll
                                                //this method lying on object
                                                //control+p-->its get a collection that extend to string(has wild card)

        System.out.println(collection == otherCollection);     //their address so false
        System.out.println(collection.equals(otherCollection));

        //---------convert our collection to ArrayList(if it could be)

        var objectArray = collection.toArray();                //toArray without argument return array of object(you can see it from view,type info)
        var stringArray = collection.toArray(new String[0]);   //when write a method, java shows the parameter and return type(return type in right side)
                                                               //and also after write method control+p show parameter type
                                                               //object[] means array of anything, we create array o string
                                                               //[0] is conventional, its means the method create correct size automatically
                                                               //otherwise we should declare the size exactly


    }
}
