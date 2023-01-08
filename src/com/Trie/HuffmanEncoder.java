package com.Trie;


import java.util.HashMap;

public class HuffmanEncoder {
//will be using heap we built(priority Queue) & in built hashMap in Java
    HashMap<Character,String> encoder;
    HashMap<String,Character> decoder;

    public HuffmanEncoder(String feeder){
         //create  a freq Map for this feeder
        HashMap<Character,Integer> fmap=new HashMap<>();
        for(int i=0;i<feeder.length();i++){
            char cc=feeder.charAt(i);
            if(fmap.containsKey(cc)){
                int ov=fmap.get(cc);
                ov=ov+1;
                fmap.put(cc,ov);
            }else{
                fmap.put(cc,1);
            }
        }

      //2 Create Min Heap Of Trees

    }


    private class Node implements Comparable<Node>{
           char data;
           int cost;
           Node left;
           Node right;

           Node(char data,int cost){
               this.data=data;
               this.cost=cost;
               this.left=null;
               this.right=null;
           }

        @Override
        public int compareTo(Node o) {
            return this.cost-o.cost;
        }
    }

}

