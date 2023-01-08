package com.RecursionChallenges;

public class MappedString {
    public static void main(String[] args) {
         mapped_Strings(1231231231,"");
    }

    public static void mapped_Strings(int n,String res){
       //System.out.println(n);
        if(n==0){
          System.out.println(res);
        }

        if(n%10!=0){
            int n2=n%10;
            int c=65+n2-1;
            mapped_Strings(n/10,(char)c+res);
        }

      //  System.out.println(n%100);
        if( n%100!=0 && n%100>=10 && n%100<=26){
            int n4=n%100;
            int c=65+n4-1;
            mapped_Strings(n/100,(char)c+res);
        }

    }


}
