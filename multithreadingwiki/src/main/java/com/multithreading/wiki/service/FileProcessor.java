package com.multithreading.wiki.service;

import com.multithreading.wiki.FileSplitter;
import com.multithreading.wiki.KeywordSplitter;
import com.multithreading.wiki.factory.FileSplitterFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by santoshk on 2/6/18.
 */
public class FileProcessor {
     static String dirPath ="input/";
    FileSplitterFactory factory = new FileSplitterFactory();

    List<FileSplitter> fileSplitServices = new ArrayList<FileSplitter>();
    static FileProcessor fileProcessor= new FileProcessor();
    List<String> keywordsList = new ArrayList<String>();

//added for testing purpose
    public static void main(String[] args) throws Exception {
        List<String> files = new ArrayList<>();
        files.add(dirPath +"Multithreading_Task2_ProgrammingLanguages.txt");
        files.add(dirPath+"Multithreading_Task_2_fortune1000companies.txt");
        files.add(dirPath+"Multithreading_Task_2_java Keywords.txt");

        fileProcessor.processFiles(files);
    }


    public void processFiles(List<String> files) throws Exception {
        //multiple files of different type ,identified on file naming convention

        ExecutorService executorService = Executors.newFixedThreadPool(files.size());

        for(String file: files){

            FileSplitter fileSplitter = factory.getFileSplitter(file);
           // Future<List<String>> keywords = executorService.submit(fileSplitter);
            fileSplitServices.add(fileSplitter);

          // System.out.print(keywords.get());
           // fileSplitServices.add(fileSplitter);


        }
        List<Future<List<String>>> keywordsList = executorService.invokeAll(fileSplitServices);








    }



}
