package com.practice;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.Callable;


public class FileWriteThread implements Callable<String> {

    String fileContent;
    String fileName;


    public FileWriteThread(String fileName, String fileContent) {
        this.fileContent=fileContent;
        this.fileName=fileName;
    }


    @Override
    public String call() throws Exception {



        try {
          FileUtils.writeStringToFile(new File(fileName+".txt"), fileContent, "UTF-16");
        } catch (IOException e) {
            return "file write failed";
        }
        return fileName + " file created";
    }
}
