// This includes three classes: Trie, TrieNode, Demo

import java.util.*;

public class Demo {
    public static void main(String args[]) {
        StringBuilder path = new StringBuilder();
        path.append("ab");
        ArrayList<String> res = new ArrayList<>();
        Trie t = new Trie();
        t.insert("abc");
        t.insert("abcd");
        t.insert("abcdefdadf");
        t.insert("ddafabcdefdadf");
        t.insert("ddabcdefdadf");

        TrieNode node = t.searchNode("ab");     // node = b

        t.allWord(node, path, res);
        for(int i=0; i<res.size(); i++){
            System.out.println(res.get(i));
        }


    }
}


// --------

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Trie {
    public TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode cur = root;
        HashMap<Character, TrieNode> curChildren = root.children;
        char[] wordArray = word.toCharArray();
        for(int i = 0; i < wordArray.length; i++){
            char c = wordArray[i];
            if(curChildren.containsKey(c)){
                cur = curChildren.get(c);
            } else {
                TrieNode newNode = new TrieNode(c);
                curChildren.put(c, newNode);
                cur = newNode;
            }
            curChildren = cur.children;
            if(i == wordArray.length - 1){
                cur.hasWord= true;
            }
        }
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        if(searchNode(word) == null){
            return false;
        } else if(searchNode(word).hasWord)
            return true;
        else return false;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        if(searchNode(prefix) == null){
            return false;
        } else return true;
    }

    public TrieNode searchNode(String s){
        HashMap<Character, TrieNode> children = root.children;
        TrieNode cur = null;
        char[] sArray = s.toCharArray();
        for(int i = 0; i < sArray.length; i++){
            char c = sArray[i];
            if(children.containsKey(c)){
                cur = children.get(c);
                children = cur.children;
            } else{
                return null;
            }
        }
        return cur;
    }

    void allWord(TrieNode node, StringBuilder path, ArrayList<String> res)
    {
        if(node.hasWord){
            res.add(path.toString());
        }

        for(Map.Entry<Character, TrieNode> entry : node.children.entrySet()){
            allWord(entry.getValue(), path.append(entry.getKey()), res);
        }

    }

}

//------------

class TrieNode {
    // Initialize your data structure here.
    char c;
    HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
    boolean hasWord;

    public TrieNode(){

    }

    public TrieNode(char c){
        this.c = c;
    }
}
