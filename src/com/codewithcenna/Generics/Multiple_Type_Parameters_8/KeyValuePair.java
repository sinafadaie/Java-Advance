package com.codewithcenna.Generics.Multiple_Type_Parameters_8;

public class KeyValuePair < K , V >{
    private K key;
    private V value;


    public KeyValuePair(K key , V value) {
        this.value = value;
        this.key = key;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}
