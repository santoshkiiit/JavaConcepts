package com.multithreading.fileoperations;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * Created by santoshk on 2/6/18.
 */
public interface  FileSplitter extends Callable<List<String>>{



    public List<String> split() throws IOException;



}



