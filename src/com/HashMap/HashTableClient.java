package com.HashMap;

public class HashTableClient {
    public static void main(String[] args) throws Exception {
        HashTable<String,Integer> m=new HashTable<>(5);
        m.put("India",1);
        m.put("USA",2);
        m.put("China",3);
        m.display();

    }
}
