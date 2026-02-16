package com.codewithcenna.Lambda_Expresions.Functional_Interface_1;

public class ConsolePrinter implements Printer {
    @Override
    public void print(String message) {
        System.out.println(message);
    }
}
