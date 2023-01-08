package com.RecursionChallenges;

public class StringToInteger {
    public static void main(String[] args) {
        System.out.println(StringToInteger("1234"));;
    }

    public static int StringToInteger(String str){
        if(str.length()==1){
            return (int)str.charAt(0)-48;
        }
        char c=str.charAt(0);
        int d=c-48;

        int n=StringToInteger(str.substring(1));
        System.out.println(n);
        //**
        int res=d*(int)Math.pow(10,str.length()-1)+n;
        return res;
    }
}
