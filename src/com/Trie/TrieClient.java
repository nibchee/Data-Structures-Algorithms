package com.Trie;

public class TrieClient {
    public static void main(String[] args) {
        Trie trie=new Trie();
        trie.addWord("arts");
        trie.addWord("art");
        trie.addWord("bug");
        trie.addWord("boy");
        trie.addWord("see");
        trie.display();
        System.out.println(trie.search("art" +
                ""));

    }
}
