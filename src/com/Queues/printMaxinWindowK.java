package com.Queues;

import java.util.Deque;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public class printMaxinWindowK {

     public static void printMax(int []arr,int k){
         Deque<Integer> q=new LinkedList<>();
         int i;
         for(i=0;i<k;i++){
             while(!q.isEmpty() && arr[i]>arr[q.getLast()]){
                 q.removeLast();
             }
             q.addLast(i);
         }

     for(;i<arr.length;i++){
         System.out.println(arr[q.getFirst()]+" ");
         //remove all useless indxes
         while(!q.isEmpty() && q.getFirst()<=i-k){
             q.removeFirst();
         }

         while(!q.isEmpty() && arr[i]>arr[q.getLast()]){
             q.removeLast();
         }

         q.addLast(i);
     }

         System.out.println(arr[q.getFirst()]);

     }



}

