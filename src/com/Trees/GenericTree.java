package com.Trees;

import java.util.ArrayList;
import java.util.Scanner;

public class GenericTree {

    private class Node{
        int data;
        ArrayList<Node> children;
       Node(int data){
           this.data=data;
           this.children=new ArrayList<>();
       }
    }

    private Node root;
    private int size;

    GenericTree(){
      Scanner s=new Scanner(System.in);
      this.root=takeInput(s,null,0);
    }

    //to take the input
    private Node takeInput(Scanner s,Node parent,int ithchild){
        if(parent==null){
            System.out.println("Enter the data for Root Node");
        }else{
            System.out.println("Enter the data for "+ithchild+"of "+parent.data);
        }

        int nodeData=s.nextInt();
        Node node=new Node(nodeData);
        this.size++;

        System.out.println("Enter the number of Childrens for"+node.data);
        int children=s.nextInt();

        //will be executed according to the value of childen
        for(int i=0;i<children;i++){
              Node child=this.takeInput(s,node,i);
              node.children.add(child);
        }
        return node;
    }


    public void display(){
     this.display(this.root);
    }

    private void display(Node node){
//node daat
        String str=node.data+"=>";
for(int i=0;i<node.children.size();i++){
   //add children data of current node
    str=str+node.children.get(i).data+" , ";
}
str+=",END";

//display for all nodes
for(int i=0;i<node.children.size();i++){
    this.display(node.children.get(i));
}
    }
}
