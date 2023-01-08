package com.Arrays;

public class Recurrsive_Bubble_Sort {


    public static void main(String[] args) {
        int []arr={9,8,7,6,5};

        int[] ans=bubble_sort(arr,arr.length-1);
       for(int val:ans)
           System.out.print(val+" ");
    }


    public static int[] bubble_sort(int []arr,int l){

        if(l==0){
            return arr;
        }
        for(int j=0;j<l;j++){
            if(arr[j]>arr[j+1])
            {
                int temp=arr[j];
                arr[j]=arr[j+1];
                arr[j+1]=temp;
            }
        }

        for(int val:arr)
            System.out.print(val+" ");

        System.out.println();
       return bubble_sort(arr,l-1);
    }






}


