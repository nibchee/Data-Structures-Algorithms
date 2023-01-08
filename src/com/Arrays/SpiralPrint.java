package com.Arrays;

import java.util.Scanner;

public class SpiralPrint {
    public static void main(String[] args) {

        Scanner s=new Scanner(System.in);

        int rows,cols;
        System.out.println("Please Enter rows");
        rows=s.nextInt();
        System.out.println("Please Enter rows");
        cols=s.nextInt();

        int arr[][]=new int[rows][cols];

        System.out.println("Please Enter arrays");
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++)
                arr[i][j]=s.nextInt();
        }

        int left=0,right=cols-1,top=0,bottom=rows-1;

        while(left<=right && top<=bottom){

            for(int j=left;j<=right;j++)
                System.out.print(arr[top][j]+" ");

            top++;


            for(int i=top;i<=bottom;i++)
                System.out.print(arr[i][right]+" ");

            right--;


            for(int j=right;j>=left;j--)
                System.out.print(arr[bottom][j]+" ");

            bottom--;

            for(int i=bottom;i>=top;i--)
                System.out.print(arr[i][left]+" ");
            left++;

        }

    }
}
