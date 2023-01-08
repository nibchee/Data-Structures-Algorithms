package com.Trees;

import java.util.LinkedList;
import java.util.Scanner;

public class BinaryTree {

    private class Node{
        int data;
        Node left;
        Node right;

        Node(int data,Node left,Node right){
            this.data=data;
            this.left=left;
            this.right=right;
        }
    }


    private Node root;
    private int size;

    BinaryTree(){
        Scanner s=new Scanner(System.in);
        this.root=takeInput(s,null,false);
    }


    private Node takeInput(Scanner s,Node parent,boolean isLeftOrRight){
        //doing work for root
        if(parent==null){
            System.out.println("Enter data forRoot Node");
        }else{
            if(isLeftOrRight){
                System.out.println("Enter the data for left child of "+parent.data);
            }else{
                System.out.println("Enter the data for right child of "+parent.data);
            }
        }

        int nodeData=s.nextInt();
        Node node=new Node(nodeData,null,null);
        this.size++;

        //For Left Node
        boolean choice=false;
        System.out.println("Do u have left child of "+node.data);
        choice=s.nextBoolean();

        if(choice){
            node.left=takeInput(s,node,true);
        }

        //for Right Node
        choice=false;
        System.out.println("Do u have rigth child of "+node.data);
        choice=s.nextBoolean();

        if(choice){
            node.right=takeInput(s,node,false);
        }

        return node;
    }


    public void display(){
     this.display(this.root);
    }

    private void display(Node node){
         String str="";
         if(node.left!=null){
           str+=node.left.data+"=>";
         }else{
             str=str+"END=>";
         }

str=str+node.data;

        if(node.right!=null){
            str+=node.right.data+"=>";
        }else{
            str=str+"<=END";
        }

        System.out.println(str);
        if(node.left!=null){
            this.display(node.left);
        }

        if(node.right!=null){
            this.display(node.right);
        }

    }


    public int height(){
 return this.height(this.root);
    }

    private int height(Node node){
        if(node==null)
            return -1;

      int lheight=this.height(node.left);
      int rheight=this.height(node.right);

      int heigt=Math.max(lheight,rheight)+1;
      return heigt;
    }

   public void preOrder(){
        this.preOrder(this.root);
   }

   private void preOrder(Node node){
        if(node==null){
            return;
        }
        System.out.println(node.data+",");
       preOrder(node.left);
       preOrder(node.right);

   }

    private void postOrder(Node node){
        if(node==null){
            return;
        }


        preOrder(node.left);
        preOrder(node.right);
        System.out.println(node.data+",");
    }


    public void levelOrder(){
        LinkedList<Node> queue=new LinkedList<>();
        queue.add(this.root);
        while(!queue.isEmpty()){
            Node rv=queue.removeFirst();
            System.out.println(rv.data+", ");
            if(rv.left!=null){
                queue.addLast(rv.left);
            }

            if(rv.right!=null){
                queue.addLast(rv.right);
            }
        }

        System.out.println("END");
}


public int diameter(){
return this.diameter(this.root);
}

private int diameter(Node node){
        if(node==null)
            return 0;
       //Case 1 when Diameter passes through the root
        int case1=this.height(node.left)+this.height(node.right)+2;
        int case2=this.diameter(node.left);
        int case3=this.diameter(node.right);


        int myans=Math.max(case1,Math.max(case2,case3));
        return myans;
    }

}
