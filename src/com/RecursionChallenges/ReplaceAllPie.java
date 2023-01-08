package com.RecursionChallenges;

import javax.xml.bind.SchemaOutputResolver;

public class ReplaceAllPie {
    public static void main(String[] args) {
        System.out.println(ReplaceAll("xpipippixx"));

    }

    public static String ReplaceAll(String str){

        if(str.length()<=1)
            return str;

        String res="";
        if(str.charAt(0)=='p' && str.charAt(1)=='i'){
            res=res+"3.14"+ReplaceAll(str.substring(2));
        }else
            res=res+str.charAt(0)+ReplaceAll(str.substring(1));
    return res;
    }
}
