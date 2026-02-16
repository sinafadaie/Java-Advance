package com.codewithcenna.Collections.Iterable_Interface_3;
//iterable interface have three method(tow of them are default)
//so we just have to implement one of them (iterator method)
//this method return an iterator object(an object that we use to iterate over an iterable!)
//--------------
//but what is iterator object? its define in iterator interface
//so we should declare it too
//if we just declare iterator(don't implement iterable)
//we can use :
//while (iterator.hasNext()){
//        var current = iterator.next();
//       System.out.println(current);
//        }
//but our foreach loop doesn't work (compiler understand our list is iterable from iterable interface )
//--------------
//the main idea for create nested class
//is the access to items and count,
//but it was possible to create a class that get this GenericList object
//and return a new ListIterator on it(due to same capable, merge them by nesting)
import java.util.Iterator;

public class GenericList<T extends  String> implements Iterable<T>{

    private T[] items ;
    private int len;
    private int count = 0;

    @Override                            //use red lamp to find method we have to implement
    public Iterator<T> iterator() {      //its return an Iterator obj
        return new ListIterator(this);   //this iterator is actually an interface declared in java.util package
    }                                    //so we have to implement this interface to use method
                                         //we should pass the current object (this)

    private class ListIterator implements Iterator<T>{  //we declare a nested class to implement iterator interface
                                                        //this interface is generic too,so by declare it nested, we can pass the main T to it
        private GenericList<T> list;
        private int index=0;

        public ListIterator(GenericList<T> list) {
            this.list = list;
        }

        @Override
        public boolean hasNext() {
            return (index < list.count);
        }

        @Override
        public T next() {
            return list.items[index++];    //because we are nested, we access to items list
        }                                  //that is the point(ListIterator class is the inside generic list implementation)
    }                                      //its the way our generic list work
    public GenericList(int len) {
        this.len = len;
        this.items = (T[]) new String[len];
    }
    public void add(T item){    //type of the parameter of this method is Object
        items[count++] = item;
    }

    public T get(int index){
        return items[index];
    }
}
