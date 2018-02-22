package com.multithreading.fileoperations;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class KeywordSplitter implements FileSplitter{


    private final String fileName;
    String pattern = ",";

    public KeywordSplitter(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<String> split() throws IOException {

        List<String>  keywords = new ArrayList<>();

        LineIterator it = FileUtils.lineIterator(new File(fileName), "UTF-8");

        while(it.hasNext()){
            String line = it.nextLine();

            if(line!=null && !line.isEmpty()){
                List<String >words = Arrays.asList(line.split(pattern));
                //words.parallelStream().
                words.forEach(word -> {
                    word = word.replaceAll("[^A-Za-z0-9]", "");
                });


                keywords.addAll(words.stream().filter(word -> !word.isEmpty()).collect(Collectors.toList()));
            }
        }
        return keywords;
    }

    @Override
    public List<String> call() throws Exception {
        return split();

    }
}
