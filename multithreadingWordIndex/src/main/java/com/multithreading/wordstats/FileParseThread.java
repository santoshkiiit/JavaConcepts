package com.multithreading.wordstats;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by santoshk on 2/7/18.
 */
public class FileParseThread implements Runnable{

    public FileParseThread(String filename, Map<String, Integer> wordcount ) {

        this.wordcount = wordcount;
        this.fileName = filename;
    }

    String fileName;

    Map<String, Integer> wordcount = new ConcurrentHashMap<>();


    @Override
    public void run() {
        try {
            this.parseFile(this.fileName,wordcount);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }



    public void parseFile(String fileName, Map<String,Integer> wordCount) throws IOException {
        File file = new File(fileName);

          if(!file.exists()){
              throw new RuntimeException("file doesn't exist");
          }
        LineIterator iterator = FileUtils.lineIterator(file);

        while(iterator.hasNext()){
            List<String> keywords = Arrays.asList(iterator.nextLine().split(" "));
            for(String word:keywords){
                word = word.replaceAll("[^A-Za-z0-9]","");
                if(!word.isEmpty()) {
                    if (wordCount.containsKey(word)) {
                        wordCount.put(word, wordCount.get(word) + 1);
                    } else {
                        wordCount.put(word, 1);
                    }
                }
            }
        }

    }




}
