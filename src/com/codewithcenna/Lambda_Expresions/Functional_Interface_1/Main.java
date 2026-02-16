package com.codewithcenna.Lambda_Expresions.Functional_Interface_1;

//a functional interface, is an interface with only a single abstract method
//like comparable interface, it is a functional interface(just have an abstract method:compareTo() )
//if an interface has default method (means has implemented in interface) it stay functional
//it does not matter if we have many default or even static method in our interface
//as long as we have a single abstract method, it's a functional interface
//---------
//static method VS default method in interfaces:
//Static method in interface
//Belongs to the interface, not instances.
//Called with InterfaceName.method().
//Cannot be overridden by implementing classes.
//Used for utility or factory methods.
//Default method in interface
//Belongs to instances of implementing classes.
//Can be called on an object (obj.method()).
//Can be overridden in implementing classes.
//Used to provide a default implementation for methods.

public class Main {
    public static void main(){
        LambdasDemo.show();
    }
}
