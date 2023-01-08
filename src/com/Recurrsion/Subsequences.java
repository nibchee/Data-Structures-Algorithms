package com.Recurrsion;

import java.util.ArrayList;
import java.util.Collections;

public class Subsequences {

    public static void main(String[] args) {
        String str="ab";
        ArrayList<String> result=subsequencesWASCII(str);
        System.out.println(result);
    }

    private static ArrayList<String> subsequences(String str){
        if(str.length()==1){
            ArrayList<String> ans=new ArrayList<>();
            ans.add(str);
            ans.add("");
            return ans;
        }

        char c=str.charAt(0);
        ArrayList<String>  r1=subsequences(str.substring(1));
        ArrayList<String> r2=new ArrayList<>();

        for(String  val:r1){
            r2.add(val);
            r2.add(c+val);
        }

        return r2;
    }

    private static ArrayList<String> subsequencesWASCII(String str){
        if(str.length()==0){
            ArrayList<String> ans=new ArrayList<>();
            ans.add("");
            return ans;
        }

        char c=str.charAt(0);
        ArrayList<String>  r1=subsequencesWASCII(str.substring(1));
        ArrayList<String> r2=new ArrayList<>();

        //System.out.println(ascii);
        for(String  val:r1){
            r2.add(val);
            r2.add(c+val);
            r2.add((int)c+val);
        }

        return r2;
    }



}

