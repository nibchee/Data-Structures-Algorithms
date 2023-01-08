package com.printRecursion;

public class PrintBoardPaths {
    static int count=0;
    public static void main(String[] args) {
        printBoardPaths(0,"",10);
       // System.out.println(count);
    }


    public static void printBoardPaths(int curr,String res,int end){
        if(curr==end){
         count++;
            System.out.println(res);
        }
        else if(curr<end){
           for(int i=1;i<=6;i++)
               printBoardPaths(curr+i,res+i,end);
        }

    }
}
