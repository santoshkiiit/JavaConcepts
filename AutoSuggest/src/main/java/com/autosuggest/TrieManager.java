package com.autosuggest;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.FileHandler;

/**
 * Created by santoshk on 2/12/18.
 */
public class TrieManager {
    static TrieImplementation trieImplementation= new TrieImplementation();
    static final String fileName = "/Users/santoshk/Projects/learning/JAVABASICS/final/test/JavaConcepts/wordcount.txt";

    static TrieManager trieManager = new TrieManager();
    public void insertWord(){





    }

    public static void main(String[] args) throws IOException {
        //added for testing purpose
        trieManager.insertWordsFromFile(fileName);
        trieManager.getAutoSuggestWords("ob");

    }


    public void insertWordsFromFile(String fileName) throws IOException {
        //reads through the wiki words list and calls the tri implementation to build a tri structure of words.

        File file = new File(fileName);


        if(!file.exists()){
            throw new RuntimeException("file doesn't exist");
        }
        LineIterator it = FileUtils.lineIterator(new File(fileName), "UTF-8");

        while(it.hasNext()){
            String word =it.nextLine();
            if(word!=null && !word.isEmpty()){
                String keyword =word.split(":")[0];
                keyword = keyword.replaceAll("[^A-Za-z0-9]","");
                keyword = keyword.toLowerCase();
                trieImplementation.insert(keyword);
            }
        }

    }

    public List<String> getAutoSuggestWords(String keyword) {
        keyword = keyword.toLowerCase();
        List<String> matchingWords = new ArrayList<>();
        matchingWords =  trieImplementation.getMatchingWords(keyword);
        return matchingWords;
    }



}








