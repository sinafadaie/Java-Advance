package com.codewithcenna.Generics.Comparable_Interface_6;

public class Main {
    public static void main(){
        var luser = new User(40);
        var huser = new User(50);

        if (luser.compareTo(huser)>0){
            System.out.println("luser > huser");
        }
        else if (luser.compareTo(huser)<0){
            System.out.println("luser < huser");
        }
        else{
            System.out.println("luser = huser");
        }
    }
}
