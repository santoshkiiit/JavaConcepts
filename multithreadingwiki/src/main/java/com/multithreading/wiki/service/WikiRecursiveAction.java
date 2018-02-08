package com.multithreading.wiki.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;

/**
 * Created by santoshk on 2/6/18.
 */
public class WikiRecursiveAction  extends RecursiveAction{

    List<String> keywords = new ArrayList<>();
    int THRESHOLD = 5;


    public String getWikiTextForKeywords(List<String> keywords){




        ForkJoinPool commonPool = ForkJoinPool.commonPool();
        return null;


    }


    public WikiRecursiveAction(List<String> keywords) {
        this.keywords = keywords;
    }

    @Override
    protected void compute() {
        if(keywords.size() >THRESHOLD){
            ForkJoinTask.invokeAll(createSubtasks(keywords));

        }else{
            fetchWikiTextNCreateFile(keywords);

        }

    }

    private void fetchWikiTextNCreateFile(List<String> keywords) {
    }

    private List<WikiRecursiveAction> createSubtasks(List<String> keywords) {



        List<WikiRecursiveAction> dividedTasks = new ArrayList<>();
        dividedTasks.add(new WikiRecursiveAction(
                keywords.subList(0,keywords.size()/2)));
        dividedTasks.add(new WikiRecursiveAction(
                keywords.subList(keywords.size()/2 +1,keywords.size())));
        return dividedTasks;
    }
}
