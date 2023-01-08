package com.RecursionChallenges;

public class RemoveDuplicates {
    public static void main(String[] args) {

        String str="aabccba";
        System.out.println(removeDuplicateChars(str));

    }

    private static String removeDuplicateChars(String str) {
        if(str.length()==0)
            return "";
        if(str.length()==1)
            return str;

        char c=str.charAt(0);
        String s=removeDuplicateChars(str.substring(1));
        String res=c+s;
        if(c==str.charAt(1)){
            res=s;
        }
        return res;
    }

}
