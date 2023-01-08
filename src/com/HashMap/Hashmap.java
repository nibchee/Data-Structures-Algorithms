package com.HashMap;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Hashmap {
    public static void main(String[] args) {
        HashMap<String,Integer> m=new HashMap();
        m.put("India",1);
        m.put("US",2);

        Set<String> keys=m.keySet();
        for(String key:keys){
            System.out.println(key);
        }

        Collection<Integer> values=m.values();
        for(Integer value:values){
            System.out.println(value);
        }

        //************Entry Set**********
        Set<Map.Entry<String,Integer>> entrySet=m.entrySet();
        for(Map.Entry<String,Integer> entry:entrySet){
            System.out.println(entry.getKey()+"=>"+entry.getValue());
        }
    }
}
