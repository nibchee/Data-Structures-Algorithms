package com.RecursionChallenges;

import java.util.ArrayList;

public class AllIndices {

    public static void main(String[] args) {
        int arr[]={3,2,1,2,3};
        System.out.println(getAllIndices(arr,2,0));
    }

    public static ArrayList<Integer>  getAllIndices(int []arr,int data,int index){
        if(index==arr.length)
            return new ArrayList<>();

        ArrayList<Integer> res=getAllIndices(arr,data,index+1);
        if(arr[index]==data)
            res.add(index);

        return  res;
    }

}
