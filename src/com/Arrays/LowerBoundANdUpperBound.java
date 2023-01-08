package com.Arrays;

public class LowerBoundANdUpperBound {

    public static void main(String args[]){
        int arr[]={1,2,2,3,4};
        System.out.println(lowerBound(arr,4));
        System.out.println(upperBound(arr,5));

    }

    public static int lowerBound(int[] arr,int data){
        int low=0,high=arr.length-1;
        int ans=-1;

        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]==data){
                ans=mid;
                high=mid-1;
            }else if(data<arr[mid]){
                high=mid-1;
            }else if(data>arr[mid]){
                low=mid+1;
            }
        }
    return ans;
    }

    public static int upperBound(int[] arr,int data){
        int low=0,high=arr.length-1;
        int ans=-1;

        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]==data){
                ans=mid;
                low=mid+1;
            }else if(data<arr[mid]){
                high=mid-1;
            }else if(data>arr[mid]){
                low=mid+1;
            }
        }
        return ans;
    }



}
