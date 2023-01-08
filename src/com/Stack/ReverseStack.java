package com.Stack;

import java.util.Stack;

public class ReverseStack {

    public static void main(String[] args) {
        Stack<Integer> s1=new Stack<>();
        s1.push(1);
        s1.push(2);
        s1.push(3);
        System.out.println(s1);

        Stack<Integer> s2=new Stack<>();

        while(!s1.isEmpty()){

            int data=s1.peek();
            s1.pop();
            while(!s2.isEmpty()){
                int ele=s2.pop();
                s1.push(ele);
            }

            s2.push(data);


        }
    }
}
