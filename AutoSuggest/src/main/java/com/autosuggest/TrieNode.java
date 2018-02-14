package com.autosuggest;

import java.util.HashMap;

/**
 * Created by santoshk on 2/12/18.
 */
public class TrieNode {
    public TrieNode rootNode;
    public Boolean isValidWord = false;
    //set if the node represents a word
    public HashMap<Character,TrieNode> children = new HashMap<Character,TrieNode>();
}
