package com.multithreading.wordstats;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by santoshk on 2/7/18.
 */


// given a directory name , containing files
// this service creates a executor service , each thread parses one file and returns
public class WordStatsService {




    static Map<String, Integer> wordCount = new ConcurrentHashMap<>();
    static String dirName = "/Users/santoshk/Projects/learning/JAVABASICS/final/JavaConcepts/output/";

    ExecutorService executorService = Executors.newFixedThreadPool(20);
    public static void main(String[] args) throws IOException, InterruptedException {
        //added for testing purpose
        WordStatsService fileParseUtility = new WordStatsService();
        fileParseUtility.parseAllFilesInDirectory(dirName);
        fileParseUtility.displayWordCount();
    }






    public void parseAllFilesInDirectory(String directoryName) throws IOException {

        File file = new File(directoryName);
        if(!file.exists()){
            throw new RuntimeException("Directory doesn't exist");
        }

        if(file.isDirectory()&&file.listFiles()!=null){
            List<File> files = Arrays.asList(file.listFiles());
            if(files.size()>0) {
                 executorService = Executors.newFixedThreadPool(files.size());


                for (File tempFile : files) {
                    if (tempFile.exists()) {
                        Thread fileParseThread = new Thread(new FileParseThread(tempFile.getPath(), wordCount));
                        executorService.submit(fileParseThread);
                    }
                }
                displayWordCount();
            }else{
                throw new RuntimeException("no files in directory");
            }


        }else {
            throw new RuntimeException("not a valid directoryName");
        }

    }

    public void displayWordCount() throws IOException {
        executorService.shutdown();
        File file = new File("wordcount2.txt");
        StringBuilder output = new StringBuilder();
        for(String key : wordCount.keySet()){
            output.append(key).append(":").append(wordCount.get(key)).append("\n");
        }
        FileUtils.writeStringToFile(file,output.toString(),"UTF-8");
    }

}
