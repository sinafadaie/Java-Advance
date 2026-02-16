package com.codewithcenna.Executor_Framework.Project_Mosh;

public class Quote {
    private final String site;      //we have to always

    private  final int price;       //valuate finals in constructor
    public Quote(String site, int price) {
        this.site = site;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Quote{"+
                "site=" + site + "," +
                "price=" + price +"}";
    }

    public String getSite() {
        return site;
    }

    public int getPrice() {
        return price;
    }

}
