package com.multithreading.wiki;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * Created by santoshk on 2/6/18.
 */
public interface  FileSplitter extends Callable<List<String>>{



    public List<String> split() throws IOException;



}



