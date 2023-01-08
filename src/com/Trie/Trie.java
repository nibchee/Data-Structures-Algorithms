package com.Trie;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Trie {

    private class Node {
        char data;
        HashMap<Character, Node> children;
        boolean isTerminal;

        Node(char data, boolean isTerminal) {
            this.data = data;
            this.children = new HashMap<>();
        }
    }

    private int numWords;
    private Node root;

    Trie() {
        this.root = new Node('\0', false);
        this.numWords = 0;
    }

    public int numWords() {
        return this.numWords;
    }

    public void addWord(String word) {
        this.addWord(this.root, word);
    }

    private void addWord(Node parent, String word) {

        //Base Case
        if (word.length() == 0) {
            if (parent.isTerminal) {
                //Word aLready exists in Trie
            } else {
                parent.isTerminal = true;
                this.numWords++;
            }
            return;
        }

        char cc = word.charAt(0);
        String ros = word.substring(1);

        //Checking present key Present in HashMap or not
        Node child = parent.children.get(cc);

        if (child == null) {
            child = new Node(cc, false);
            parent.children.put(cc, child);
        }

        this.addWord(child, ros);
    }


    public void display() {
        this.display(this.root, "");
    }

    private void display(Node node, String osf) {

        if (node.isTerminal) {
            String toDisplay = osf;
            System.out.println(toDisplay);
        }

        Set<Map.Entry<Character, Node>> enteries = node.children.entrySet();
        for (Map.Entry<Character, Node> entry : enteries) {
            this.display(entry.getValue(), osf + entry.getKey());
        }
    }


    public boolean search(String word) {
        return this.search(this.root, word);
    }

    private boolean search(Node node, String word) {

        if (word.length() == 0) {
            return node.isTerminal;
        }

        char cc = word.charAt(0);
        Node n = node.children.get(cc);
        String ros = word.substring(1);

        if (n == null) {
            return false;
        }

        return this.search(n, ros);
    }


    public void remove(String word) {
        this.remove(this.root, word);
    }

    private void remove(Node parent, String word) {
        if(word.length()==0){
            if(parent.isTerminal){
               parent.isTerminal=false;
               this.numWords--;
            }else{
              //word is part of some another word
            }
        }

        char cc = word.charAt(0);
        String ros = word.substring(1);
        Node child = parent.children.get(cc);

        if (child == null)
            return;

        this.remove(child, ros);

        //Now while Backtracking removing other nodes
        if(!child.isTerminal && child.children.size()==0){
            parent.children.remove(cc);
        }

    }
}



