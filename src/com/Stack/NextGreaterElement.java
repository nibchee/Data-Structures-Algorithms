package com.Stack;

import java.util.Stack;

public class NextGreaterElement {

    public static void main(String[] args) {
        Stack<Integer> s=new Stack<Integer>();
        int arr[]={2,1,3,8,6,7,5};

        for(int i=0;i<arr.length;i++){

            while(!s.isEmpty() && arr[i]>s.peek()){
                int data=s.pop();
                System.out.println(data+"-->"+arr[i]);
            }

            s.push(arr[i]);
        }

        while(!s.isEmpty()){
            int data=s.pop();
            System.out.println(data+"-->"+-1);
        }

    }
}
