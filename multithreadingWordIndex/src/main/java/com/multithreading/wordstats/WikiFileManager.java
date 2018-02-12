package com.multithreading.wordstats;

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
public class WikiFileManager {

    static Map<String, Integer> wordCount = new ConcurrentHashMap<>();
    static String dirName = "/Users/santoshk/Projects/learning/JAVABASICS/final/JavaConcepts/output/";

    public static void main(String[] args) throws IOException, InterruptedException {
        //added for testing purpose
        WikiFileManager fileParseUtility = new WikiFileManager();
        fileParseUtility.parseAllFilesInDirectory(dirName);
        fileParseUtility.displayWordCount();
    }






    public void parseAllFilesInDirectory(String directoryName) throws IOException {

        File file = new File(directoryName);
        if(!file.exists()){
            throw new RuntimeException("Directory doesn't exist");
        }

        if(file.isDirectory()){
            List<File> files = Arrays.asList(file.listFiles());
            ExecutorService executorService = Executors.newFixedThreadPool(files.size());

            for(File tempFile:files){
                if(tempFile.exists()){
                    Thread fileParseThread = new Thread(new FileParseThread(tempFile.getPath(), wordCount));
                    executorService.submit(fileParseThread);

                }

            }
            executorService.shutdown();

            while(!executorService.isTerminated()){
               //wait
            }
            displayWordCount();


        }else {
            throw new RuntimeException("not a valid directoryName");
        }

    }

    public String displayWordCount(){
        StringBuilder output = new StringBuilder();
        for(String key : wordCount.keySet()){
            output.append(key).append(":").append(wordCount.get(key)).append("\n");
        }
        return output.toString();
    }
}
