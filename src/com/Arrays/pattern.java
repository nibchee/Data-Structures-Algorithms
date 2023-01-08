package com.Arrays;

public class pattern {

    public static void main(String[] args) {
        print_pattern2(5,1,1);
    }

    private static void print_pattern(int n, int r, int c) {

        if(r<=n){
            c=r;
            for(int j=1;j<=c;j++)
                System.out.print("* ");

            System.out.println();
            print_pattern(n,r+1,c);
        }
    }

    private static void print_pattern2(int n, int r, int c) {


        if(r>n)
            return;
        if(c>r){
            System.out.println();
            print_pattern2(n,r+1,1);
        return;
        }
        System.out.print("*");
        print_pattern2(n,r,c+1);
    }

}
