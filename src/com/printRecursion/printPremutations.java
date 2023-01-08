package com.printRecursion;

public class printPremutations {
    public static void main(String[] args) {
        printPremutations("abc","");
    }

    public static void printPremutations(String str,String res){
        if(str.length()==0){
            System.out.println(res);
        }else{
            for(int i=0;i<str.length();i++){
                char c=str.charAt(i);
                String new_str=str.substring(0,i)+str.substring(i+1);
                printPremutations(new_str,res+c);
            }
        }
    }
}
