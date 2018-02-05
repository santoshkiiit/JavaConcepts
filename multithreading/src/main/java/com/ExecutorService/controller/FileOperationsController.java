package com.ExecutorService.controller;

import com.ExecutorService.FileWriter;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class FileOperationsController {

    ExecutorService executorService = Executors.newFixedThreadPool(20);
    int fileNameCounter = 10001;


    public void writeToFile(String fileContent) {

        fileNameCounter++;
        executorService.submit(new FileWriter(String.valueOf("/Users/santoshk/Downloads/temp/"+fileNameCounter),fileContent));
    }




    public void splitFile(String filePath, int numLines) {

        try {

            File file = new File(filePath);
            StringBuffer lines = new StringBuffer();
            LineIterator it = FileUtils.lineIterator(file, "UTF-8");
            int count = 0;
            while (it.hasNext()) {
                count++;
                lines.append(it.nextLine());
                if (count == numLines) {
                    writeToFile(lines.toString());
                    lines= new StringBuffer();
                    count = 0;
                }

            }
            writeToFile(lines.toString());
            executorService.shutdown();


        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
