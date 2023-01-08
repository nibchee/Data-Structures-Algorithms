package com.HashMap;

public class LinkedList<T> {

    private class Node{
        T data;
        Node next;
    }

    private Node head;
    private Node tail;
    private int size;

    //O(N)
    public void display(){
        Node temp=this.head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }

    }

    public void addLast(T item){
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


    public void addFirst(T data){
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
    public T getFirst() throws Exception {
        if(this.size==0){
            throw new Exception("LL is Empty.");
        }
        return this.head.data;
    }

    //O(1)
    public T getLast() throws Exception{
        if(this.size==0){
            throw new Exception("LL is Empty.");
        }
        return this.tail.data;
    }

    public T getAt(int idx) throws Exception{
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

    public T removeFirst() throws  Exception{
        if(this.size==0){
            throw new Exception("LL is Empty");
        }

        T rv=this.head.data;
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
    public T removeAt(int idx) throws Exception{
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


    public T removeLast() throws  Exception{
        if(this.size==0){
            throw  new Exception("LL is empty");
        }

        T rv=this.tail.data;

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


    //retunr index
    public int find(T data){
        int index=0;
        for(Node temp=this.head;temp!=null;temp=temp.next){
            if(temp.data.equals(data)){
                return index;
            }
            index++;
        }
        return -1;
    }

    public boolean isEmpty(){
        return this.size==0;
    }
}
