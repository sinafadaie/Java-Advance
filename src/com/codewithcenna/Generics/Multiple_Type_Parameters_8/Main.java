package com.codewithcenna.Generics.Multiple_Type_Parameters_8;

//some time we need multiple type parameter
//like printing key and value (key has own type, value has own type)
//key maybe is a number or string or ...(value has same situation)
//--------------
//in tow type parameter, in conventional
//we use K,V(stand for key,value)
//--------------
//we can have a genric method for multiple type parameter
//and also can have entire generic class for multiple parameter


public class Main {
    public static void main() {

        Utils.print(4,5);
        Utils.print(4,"Sina");
        Utils.print("Sina",4);

        KeyValuePair<Integer, String> keyValuePair = new KeyValuePair<>(4, "Sina");
        System.out.println(keyValuePair.getKey());
        System.out.println(keyValuePair.getValue());
    }
}
