package com.RecursionChallenges;

public class MoveAllXAtEnd {
    public static void main(String[] args) {
        System.out.println(moveX("abexexdexdexed"));
    }

    public static String moveX(String str){
        if(str.length()==1)
            return str;

        String res="";
        if(str.charAt(0)=='x')
            res=moveX(str.substring(1))+'x';
        else
            res=str.charAt(0)+moveX(str.substring(1));

        return  res;
    }

}
