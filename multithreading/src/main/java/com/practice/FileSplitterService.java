package com.practice;



import com.practice.controller.FileOperationsController;

import java.util.Scanner;



public class FileSplitterService {

    static FileOperationsController controller = new FileOperationsController();


    public static void main(String[] args) {
        //added for testing purpose

        Scanner s = new Scanner(System.in);

        String fileName = s.nextLine();
        int numLines = s.nextInt();
        controller.splitFile(fileName, numLines);




    }
}
