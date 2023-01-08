package com.Graph;

import java.util.HashMap;

public class GraphClient {
    public static void main(String[] args) {
        Graph graph=new Graph();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");
        graph.addVertex("G");
      //  graph.display();
        graph.addEdge("A","B",2);
        graph.addEdge("A","D",3);
        graph.addEdge("B","C",1);
        graph.addEdge("C","D",8);
        graph.addEdge("D","E",10);
        graph.addEdge("E","F",45);
        graph.addEdge("E","G",7);
        graph.addEdge("F","G",8);
       graph.display();
        //System.out.println(graph.hasPath("A","F",new HashMap<>()));

        //System.out.println(graph.bfs("A","F"));
        graph.dft();
    }

}
