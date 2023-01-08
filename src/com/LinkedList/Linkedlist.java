package com.LinkedList;

public class Linkedlist {

    private class Node{
        int data;
        Node next;
    }

    private Node head;
    private Node tail;
    private int size;

    //O(N)
    public void display(){
        Node temp=this.head;
        while(temp!=null){
            System.out.println(temp.data+" ");
            temp=temp.next;
        }

    }

    public void addLast(int item){
        //create a new Node
        Node nn=new Node();
        nn.data=item;
        nn.next=null;

      //attach
        if(this.size>=1){
            this.tail.next=nn;
        }

        //summary object
        if(this.size==0){
            this.head=nn;
            this.tail=nn;
            this.size++;
        }else{
            this.tail=nn;
            this.size++;
        }

    }


    public void addFirst(int data){
        Node nn=new Node();
        nn.data=data;


        //summary object
        if(this.size==0){
            this.head=nn;
            this.tail=nn;
            this.size++;
        }else{
            nn.next=this.head;
            this.head=nn;
            this.size++;
        }
    }


    private Node getNodeAt(int idx) throws Exception{
        if(this.size==0){
            throw new Exception("LL is Empty");
        }

        if(idx<0 || idx>=this.size){
            throw new Exception("Invalid Index.");
        }

        Node temp=this.head;
        for(int i=1;i<=idx;i++){
            temp=temp.next;
        }

     return temp;
    }

    //O(1)
    public int getFirst() throws Exception {
        if(this.size==0){
            throw new Exception("LL is Empty.");
        }
        return this.head.data;
    }

    //O(1)
    public int getLast() throws Exception{
        if(this.size==0){
            throw new Exception("LL is Empty.");
        }
        return this.tail.data;
    }

    public int getAt(int idx) throws Exception{
        if(this.size==0){
            throw new Exception("LL is Empty.");
        }
        if(idx<0 || idx>=this.size){
            throw new Exception("Invalid Index.");
        }

        Node temp=this.head;
        for(int i=1;i<idx;i++){
            temp=temp.next;
        }

        return temp.data;
    }

    public int removeFirst() throws  Exception{
        if(this.size==0){
            throw new Exception("LL is Empty");
        }

        int rv=this.head.data;
        if(this.size==1){
         this.head=null;
         this.tail=null;
         this.size=0;
        }else{
            this.head=this.head.next;
            this.size--;

        }

return rv;

    }


//O(n)
    public int removeAt(int idx) throws Exception{
        if(this.size==0){
            throw new Exception("LL is Empty.");
        }
        if(idx<0 || idx>=this.size){
            throw new Exception("Invalid Index.");
        }

        if(idx==0){
            return removeFirst();
        }else if(idx==this.size-1){
            return removeLast();
        }else {
            Node nm1 = getNodeAt(idx - 1);
            Node n = nm1.next;
            Node np1 = n.next;

            nm1.next = np1;
            this.size--;
            return n.data;

        }
    }


    public int removeLast() throws  Exception{
        if(this.size==0){
            throw  new Exception("LL is empty");
        }

        int rv=this.tail.data;

        if(this.size==1){
            this.head=null;
            this.tail=null;
            this.size=0;
        }else{
            Node sizem2=getNodeAt(this.size-2);
            this.tail=sizem2;
            this.tail.next=null;
            this.size--;
        }
return rv;
    }

    public void reverseData() throws Exception{
        int left=0;
        int right=this.size-1;

          while(left<right){
              Node ln=getNodeAt(left);
              Node rn=getNodeAt(right);

              int temp=ln.data;
              ln.data=rn.data;
              rn.data=temp;

              left++;
              right--;
          }
          }



            public void reversePointers(){
         Node prev=this.head;
         Node curr=prev.next;

         while(curr!=null){
             Node ahead=curr.next;
             curr.next=prev;

              prev=curr;
              curr=ahead;
         }

         //swap
                Node t=this.head;
         this.head=this.tail;
         this.tail=t;


         this.tail.next=null;
            }

            public int mid(){
            Node slow=this.head;
            Node fast=this.head;

            while(fast.next!=null && fast.next.next!=null){
                slow=slow.next;
                fast=fast.next.next;
            }

            return slow.data;
            }
}
