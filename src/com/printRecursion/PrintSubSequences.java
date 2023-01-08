package com.printRecursion;

public class PrintSubSequences {

    public static void main(String[] args) {
printSS("abc","");
    }


    public static void printSS(String str,String res){

        if(str.length()==0){
            System.out.print("\""+res+"\" ");
        }
else {
            //Not Including first Character in result
            printSS(str.substring(1), res);
            //Including first Character in result
            printSS(str.substring(1), res+str.charAt(0) );


        }
}


}


