package com.practice.controller;


import com.practice.FileWriteThread;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class FileOperationsController {

    ExecutorService executorService = Executors.newFixedThreadPool(20);
    int fileNameCounter = 10001;


    public void writeToFile(String fileContent) {

        fileNameCounter++;
        executorService.submit(new FileWriteThread(String.valueOf(fileNameCounter+".txt"),fileContent));
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
            //one thread for each file write operation
            executorService.shutdown();


        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
