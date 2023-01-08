package com.Graph;

import com.Heap.HeapGeneric;
import sun.awt.image.ImageWatched;

import java.util.*;

public class Graph {
    private class Vertex{
        HashMap<String,Integer> nbrs=new HashMap<>();
    }
    HashMap<String,Vertex> vtces;
    public Graph(){
        vtces=new HashMap<>();
    }
    //Returns count of vertex in graph
    public int numVertex(){
        return this.vtces.size();
    }
    public boolean containsVertex(String vname){
      return this.vtces.containsKey(vname);
    }
    public void addVertex(String vname){
       Vertex vtx=new Vertex();
       vtces.put(vname,vtx);
    }
    public void removeVertex(String vname){
          Vertex vtx=vtces.get(vname);
          ArrayList<String> keys=new ArrayList<>(vtx.nbrs.keySet());
         for(String key:keys){
            Vertex nbrVtx=vtces.get(key);
            nbrVtx.nbrs.remove(vname);
         }
         vtces.remove(vname);
    }
    public int numEdges(){
        int count=0;
         ArrayList<String> keys=new ArrayList<>(vtces.keySet());
          for(String key:keys){
          Vertex vtx=vtces.get(key);
          count= count+vtx.nbrs.size();
          }
          return count/2;
    }
    public boolean containsEdge(String vname1,String vname2){
         Vertex vtx1=vtces.get(vname1);
         Vertex vtx2=vtces.get(vname2);

         if(vtx1==null || vtx2==null||!vtx1.nbrs.containsKey(vname2)){
              return false;
         }

         return true;
    }
    public void addEdge(String vname1,String vname2,int cost){
        Vertex vtx1=vtces.get(vname1); //2k
        Vertex vtx2=vtces.get(vname2);  //4k

        if(vtx1==null || vtx2==null){
            return;
        }

       vtx1.nbrs.put(vname2,cost);  //2k nbrs put C with given cost
        vtx2.nbrs.put(vname1,cost); //4k nbrsput A with given cost
    }
    public void removeEdge(String vname1,String vname2){
        Vertex vtx1=vtces.get(vname1); //2k
        Vertex vtx2=vtces.get(vname2);  //4k

        if(vtx1==null || vtx2==null||!vtx1.nbrs.containsKey(vname2)){
            return ;
        }

        vtx1.nbrs.remove(vname2);  //2k nbrs put C with given cost
        vtx2.nbrs.remove(vname1); //4k nbrsput A with given cost
    }
    public void display(){
        System.out.println("---------------------------");
        ArrayList<String> keys=new ArrayList<>(vtces.keySet());
        for(String key:keys){
            Vertex vtx=vtces.get(key);
            System.out.println(key+" : "+vtx.nbrs);
        }
        System.out.println("-------------------------------");
    }
    /* Infintely Traverses on same nodes
    public boolean hasPath(String vname1,String vname2){
        //check wether there exists direct edge or not
        if(containsEdge(vname1,vname2)){
            return true;
        }

       Vertex vtx=vtces.get(vname1);
        ArrayList<String> nbrs=new ArrayList<>(vtx.nbrs.keySet());

        for(String nbr:nbrs){
            if(hasPath(nbr,vname2)){
                return true;
            }
        }
        return false;
    }
    */
    public boolean hasPath(String vname1,String vname2,HashMap<String,Boolean> processed){
        processed.put(vname1,true);
        //check wether there exists direct edge or not
        if(containsEdge(vname1,vname2)){
            return true;
        }

        Vertex vtx=vtces.get(vname1);
        ArrayList<String> nbrs=new ArrayList<>(vtx.nbrs.keySet());

        for(String nbr:nbrs){
            if(!processed.containsKey(nbr)) {
                if (hasPath(nbr, vname2, processed)){
                    return true;
                }
            }
        }
        return false;
    }
    //for BFS DFS
    private class Pair{
         String vname;
         String psf;
    }
    public boolean bfs(String src,String dst){
        //Processed Map
        HashMap<String,Boolean> processed=new HashMap<>();

        LinkedList<Pair> queue=new LinkedList<>();

        //create a new pair
        Pair sp=new Pair();
        sp.vname=src;
        sp.psf=src;

        //put the new pair in queue
        queue.addLast(sp);

        //while queue is not empty keep on doing the work
        while(!queue.isEmpty()){
            //remove a pair from queue
            Pair rp=queue.removeFirst();

            if(processed.containsKey(rp.vname)){
                continue;
            }

            //processed pair
            processed.put(rp.vname,true);

            //direct edge
            if(containsEdge(rp.vname,dst)){
                System.out.println(rp.psf+dst);
                return true;
            }

            //nbrs
            Vertex rpvtx=vtces.get(rp.vname);
            ArrayList<String> nbrs=new ArrayList<>(rpvtx.nbrs.keySet());


            //loop
            for(String nbr:nbrs){
                //process only unprocessed nbrs
                if(!processed.containsKey(nbr)){

                    //make a new pair of nbr & put in queue
                    Pair np=new Pair();
                    np.vname=nbr;
                    np.psf=rp.psf+nbr;

                    queue.addLast(np);
                }
            }

        }


    return false;
    }
    public boolean dfs(String src,String dst){
        HashMap<String,Boolean>  processed=new HashMap<>();
        LinkedList<Pair> stack=new LinkedList<>();

        //create a new Pair
        Pair sp=new Pair();
        sp.vname=src;
        sp.psf=src;

        //put the new pair in stack
        stack.addLast(sp);

        while(!stack.isEmpty()){

            //remove  a pair from stack
            Pair rp=stack.removeFirst();

            if(processed.containsKey(rp.vname)){
                continue;
            }

            //processed put
            processed.put(rp.vname,true);

            //direct edge
            if(containsEdge(rp.vname,dst)){
                System.out.println(rp.psf+dst);
                return  true;
            }

            //nbrs
            Vertex rpvtx=vtces.get(rp.vname);
            ArrayList<String> nbrs=new ArrayList<>(rpvtx.nbrs.keySet());

            //loop on nbrs
            for(String nbr:nbrs){

                //process only unprocessed nbrs
                if(!processed.containsKey(nbr)){

                    //make a new pair of nbr & put in a queue
                    Pair np=new Pair();
                    np.vname=nbr;
                    np.psf=rp.psf+nbr;

                    stack.addFirst(np);
                }
            }
        }
  return false;
    }
    public void bft(){
        //Processed Map
        HashMap<String,Boolean> processed=new HashMap<>();
        LinkedList<Pair> queue=new LinkedList<>();
        ArrayList<String> keys=new ArrayList<>(vtces.keySet());

        //for every node repeat the process
        for(String key:keys){
            //this processed is for connected componenets
            if(processed.containsKey(key))
                continue;

            //create a new pair
            Pair sp=new Pair();
            sp.vname=key;
            sp.psf=key;

            //put the new pair in queue
            queue.addLast(sp);

            //while queue is not empty keep on doing the work
            while(!queue.isEmpty()){
                //remove a pair from queue
                Pair rp=queue.removeFirst();
                //fir repeated nodes let us suppose 2 node can be processed by 2 h ways
                if(processed.containsKey(rp.vname)){
                    continue;
                }

                //processed pair
                processed.put(rp.vname,true);

                //syso
                System.out.println(rp.vname+" "+rp.psf);

                //nbrs
                Vertex rpvtx=vtces.get(rp.vname);
                ArrayList<String> nbrs=new ArrayList<>(rpvtx.nbrs.keySet());

                //loop
                for(String nbr:nbrs){
                    //process only unprocessed nbrs
                    if(!processed.containsKey(nbr)){
                        //make a new pair of nbr & put in queue
                        Pair np=new Pair();
                        np.vname=nbr;
                        np.psf=rp.psf+nbr;
                        queue.addLast(np);
                    }
                }
            }


        }
    }
    public void dft(){
        //processed Map
        HashMap<String,Boolean> processed=new HashMap<>();

        LinkedList<Pair> stack =new LinkedList<>();

        ArrayList<String> keys=new ArrayList<>(vtces.keySet());

        for(String key:keys){

            //for disconnected graph to traverse that compnents also
            if(processed.containsKey(key))
                continue;

            Pair sp=new Pair();
            sp.vname=key;
            sp.psf=key;

            stack.addFirst(sp);

            while(!stack.isEmpty()){

                Pair rp=stack.removeFirst();

                //if there are more than one path for particular node
                if(processed.containsKey(rp.vname))
                    continue;

                //Set its processing as true
                processed.put(rp.vname,true);
                //Print it
                System.out.println(rp.vname+" "+rp.psf);

                //neighbours for this
                ArrayList<String> nbrs=new ArrayList<>(vtces.get(rp.vname).nbrs.keySet());
                //Pushing each neighbour in stack
                for(String nbr:nbrs){
                    Pair p=new Pair();
                    p.vname=nbr;
                    p.psf=rp.psf+nbr;

                    stack.addFirst(p);
                }

             }
        }
    }
    public boolean isCyclic(){
        //Processed Map
        HashMap<String,Boolean> processed=new HashMap<>();
        LinkedList<Pair> queue=new LinkedList<>();
        ArrayList<String> keys=new ArrayList<>(vtces.keySet());

        //for every node repeat the process
        for(String key:keys){
            //this processed is for connected componenets
            if(processed.containsKey(key))
                continue;

            //create a new pair
            Pair sp=new Pair();
            sp.vname=key;
            sp.psf=key;

            //put the new pair in queue
            queue.addLast(sp);

            //while queue is not empty keep on doing the work
            while(!queue.isEmpty()){
                //remove a pair from queue
                Pair rp=queue.removeFirst();
                //fir repeated nodes let us suppose 2 node can be processed by 2 h ways
                if(processed.containsKey(rp.vname)){
                    return true;
                }

                //processed pair
                processed.put(rp.vname,true);

                //syso
                System.out.println(rp.vname+" "+rp.psf);

                //nbrs
                Vertex rpvtx=vtces.get(rp.vname);
                ArrayList<String> nbrs=new ArrayList<>(rpvtx.nbrs.keySet());

                //loop
                for(String nbr:nbrs){
                    //process only unprocessed nbrs
                    if(!processed.containsKey(nbr)){
                        //make a new pair of nbr & put in queue
                        Pair np=new Pair();
                        np.vname=nbr;
                        np.psf=rp.psf+nbr;
                        queue.addLast(np);
                    }
                }
            }


        }
        return false;
    }
    public boolean isConnected(){
        int flag=0;
        //Processed Map
        HashMap<String,Boolean> processed=new HashMap<>();
        LinkedList<Pair> queue=new LinkedList<>();
        ArrayList<String> keys=new ArrayList<>(vtces.keySet());

        //for every node repeat the process
        for(String key:keys){
            //this processed is for connected componenets
            if(processed.containsKey(key))
                continue;
             flag++;
            //create a new pair
            Pair sp=new Pair();
            sp.vname=key;
            sp.psf=key;

            //put the new pair in queue
            queue.addLast(sp);

            //while queue is not empty keep on doing the work
            while(!queue.isEmpty()){
                //remove a pair from queue
                Pair rp=queue.removeFirst();
                //fir repeated nodes let us suppose 2 node can be processed by 2 h ways
                if(processed.containsKey(rp.vname)){
                    continue;
                }
                //processed pair
                processed.put(rp.vname,true);

                //syso
                //System.out.println(rp.vname+" "+rp.psf);

                //nbrs
                Vertex rpvtx=vtces.get(rp.vname);
                ArrayList<String> nbrs=new ArrayList<>(rpvtx.nbrs.keySet());

                //loop
                for(String nbr:nbrs){
                    //process only unprocessed nbrs
                    if(!processed.containsKey(nbr)){
                        //make a new pair of nbr & put in queue
                        Pair np=new Pair();
                        np.vname=nbr;
                        np.psf=rp.psf+nbr;
                        queue.addLast(np);
                    }
                }
            }



        }
    if(flag>=2){
        return false;
    }else{
        return true;
    }
    }
    public boolean isTree(){
        return !isCyclic() && isConnected();
    }
    public ArrayList<ArrayList<String>> getConnectedComponents(){
        ArrayList<ArrayList<String>> ans=new ArrayList<>();

        //Processed Map
        HashMap<String,Boolean> processed=new HashMap<>();
        LinkedList<Pair> queue=new LinkedList<>();
        ArrayList<String> keys=new ArrayList<>(vtces.keySet());

        //for every node repeat the process
        for(String key:keys){

            //this processed is for connected componenets
            if(processed.containsKey(key))
                continue;

            //for a new component create a new ArrayList
            ArrayList<String> subans=new ArrayList<>();
            //create a new pair
            Pair sp=new Pair();
            sp.vname=key;
            sp.psf=key;

            //put the new pair in queue
            queue.addLast(sp);

            //while queue is not empty keep on doing the work
            while(!queue.isEmpty()){
                //remove a pair from queue
                Pair rp=queue.removeFirst();
                //fir repeated nodes let us suppose 2 node can be processed by 2 h ways
                if(processed.containsKey(rp.vname)){
                    continue;
                }

                //processed pair
                processed.put(rp.vname,true);

                //syso
                //System.out.println(rp.vname+" "+rp.psf);
               //put in subans array list
                subans.add(rp.vname);

                //nbrs
                Vertex rpvtx=vtces.get(rp.vname);
                ArrayList<String> nbrs=new ArrayList<>(rpvtx.nbrs.keySet());

                //loop
                for(String nbr:nbrs){
                    //process only unprocessed nbrs
                    if(!processed.containsKey(nbr)){
                        //make a new pair of nbr & put in queue
                        Pair np=new Pair();
                        np.vname=nbr;
                        np.psf=rp.psf+nbr;
                        queue.addLast(np);
                    }
                }
            }

            //put in final answer
            ans.add(subans);
        }

return ans;
    }

    public class PrimsPair implements Comparable<PrimsPair> {
        String vname;
        String acqvname;
        int cost;

        @Override
        public int compareTo(PrimsPair o) {
            return o.cost-this.cost;
        }
    }

    public Graph prims(){
        Graph mst=new Graph();
        HashMap<String,PrimsPair> map=new HashMap<>();

        HeapGeneric<PrimsPair> heap=new HeapGeneric<>();

        //make a pair & put in heap and map
        for(String key: vtces.keySet()){
            PrimsPair np=new PrimsPair();
            np.vname=key;

            np.acqvname=null;
            np.cost=Integer.MAX_VALUE;

            heap.add(np);
            map.put(key,np);
        }

        //till the heap is not empty keep on removing the pairs
        while(!heap.isEmpty()){

            //remove a pair
            PrimsPair rp=heap.remove();
            map.remove(rp.vname);

            //add to mst
            if(rp.acqvname==null){
                mst.addVertex(rp.vname);
            }else{
                mst.addVertex(rp.vname);
                mst.addEdge(rp.vname,rp.acqvname,rp.cost);
            }

            //nbrs
            for(String nbr:vtces.get(rp.vname).nbrs.keySet()){
                //work for nbrs which are in heap
                if(map.containsKey(nbr)){
                    //old cost
                    int oc=map.get(nbr).cost;
                    //new cost
                    int nc=vtces.get(rp.vname).nbrs.get(nbr);

                    //update th epair
                    if(nc<oc){
                        PrimsPair gp=map.get(nbr);
                        gp.acqvname=rp.vname;
                        gp.cost=nc;
                    }

                }
            }
        }
        return mst;
    }



}
