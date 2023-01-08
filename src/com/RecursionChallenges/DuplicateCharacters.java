package com.RecursionChallenges;

public class DuplicateCharacters {
    public static void main(String[] args) {

        String str="";
        System.out.println(duplicateChars(str));

    }

    private static String duplicateChars(String str) {
        if(str.length()==0)
            return "";
        if(str.length()==1)
            return str;

        char c=str.charAt(0);
        String s=duplicateChars(str.substring(1));
        String res=c+s;
        if(c==str.charAt(1)){
            res=c+"*"+s;
        }
        return res;
    }


}
