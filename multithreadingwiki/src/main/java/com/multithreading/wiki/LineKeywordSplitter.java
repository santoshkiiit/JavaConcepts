package com.multithreading.wiki;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;

public class LineKeywordSplitter implements FileSplitter{

    private final String fileName;
    String pattern = "/n";

    public LineKeywordSplitter(String fileName) {
        this.fileName = fileName;
    }



    @Override
    public List<String> split() throws IOException {

        List<String>  keywords = new ArrayList<>();

        LineIterator it = FileUtils.lineIterator(new File(fileName), "UTF-8");

        while(it.hasNext()){
            String line = it.nextLine();

            if(line!=null && !line.isEmpty()){
                keywords.addAll(Arrays.asList(line.split(pattern)).stream().filter(word -> !word.isEmpty()).collect(Collectors.toList()));
            }
        }
        return keywords;
    }

    @Override
    public List<String> call() throws Exception {
        return split();
    }
}
