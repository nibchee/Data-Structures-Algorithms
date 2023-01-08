package com.company.GoogleKickStart;

import java.util.*;
public class Solution{

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int test_cases=sc.nextInt();
        for(int t=1;t<=test_cases;t++){
            Long L=sc.nextLong();
            int N=sc.nextInt();
            Long laps=0l;
            Long prevRem=0l;
            char prev_C=' ';
            for(int i=0;i<N;i++){

                Long D=sc.nextLong();
                char C=sc.next().charAt(0);
                Long div=D/L;
                Long rem=D%L;
                if((C=='A' && prev_C=='C')||(C=='C' && prev_C=='A')){
                    rem=prevRem-rem;
                    if(rem<0){
                        div--;
                        rem=L+(prevRem-rem);
                    }else{
                        rem=prevRem-rem;
                    }
                }else{
                    rem=rem+prevRem;
                    if(rem/L==1) {
                        div++;
                        rem = rem % L;
                    }
                }
                laps+=div;
                prev_C=C;
                prevRem=rem;
            }
            System.out.println("Case #"+t+": "+laps);

        }
    }
}