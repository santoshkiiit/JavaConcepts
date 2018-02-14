package com.autosuggest;

import java.util.*;

/**
 * Created by santoshk on 2/12/18.
 */
public class TrieImplementation {

    private HashMap<Character,TrieNode> rootNode = new HashMap<Character,TrieNode>();


        public TrieNode getRootNodeForString(HashMap<Character,TrieNode> parentNode, String string) {

            if (parentNode.containsKey(string.charAt(0))) {
                if (string.length()==1) {
                       return parentNode.get(string.charAt(0));
                }
                  return searchForRootNode(string.substring(1), parentNode.get(string.charAt(0))) ;
                } else {
               return null;
            }
}


    private TrieNode searchForRootNode(String string, TrieNode node) {

        if (node.children.containsKey(string.charAt(0))) {
            if(string.length()==1){
                return node.children.get(string.charAt(0));
            }
            return searchForRootNode(string.substring(1), node.children.get(string.charAt(0)));
        } else {
            return null;
        }

    }


    public List<String>  getMatchingWords(String word){

        List<String> matchingWords = new ArrayList<>();
        TrieNode node = getRootNodeForString(this.rootNode, word);
        if(node!=null){
            matchingWords = getWordsInANode(node,word);
        }
        return matchingWords;

    }

    private List<String> getWordsInANode(TrieNode targetNode, String string){

        List<String> suggestions = new ArrayList<>();
        if(targetNode.isValidWord){
            suggestions.add(string);
        }
        Set<Map.Entry<Character, TrieNode>> entries = targetNode.children.entrySet();

        if(entries!=null && entries.size()>0) {
            for (Map.Entry entry : entries) {
                entry.getKey();
                suggestions.addAll(getWordsInANode((TrieNode) entry.getValue(), string + entry.getKey()));
            }
        }
        return suggestions;
    }

    //Adds a new word to the trie tree.
    public void insert(String string) {
        if (!rootNode.containsKey(string.charAt(0))) {
            rootNode.put(string.charAt(0), new TrieNode());
        }
        if(string.length()==1){
            //a word  from the input, mark the node as a valid word
            rootNode.get(string.charAt(0)).isValidWord =true;
        }
        else{
            insertWord(string.substring(1), rootNode.get(string.charAt(0)));
        }
    }

    public  void insertWord(String string, TrieNode node) {
        final TrieNode nextChild;
        if (node.children.containsKey(string.charAt(0))) {
            nextChild = node.children.get(string.charAt(0));
        } else {
            nextChild = new TrieNode();
            node.children.put(string.charAt(0), nextChild);
        }

        if (string.length() == 1) {
            nextChild.isValidWord = true;
            return;
        } else {
            insertWord(string.substring(1),nextChild);
        }
    }


}
