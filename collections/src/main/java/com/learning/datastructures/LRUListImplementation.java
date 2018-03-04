package com.learning.datastructures;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by santoshk on 3/2/18.
 */
public class LRUListImplementation {

    List<Node> cacheList = new ArrayList<>();

    public boolean checkIfUrlExists(String url){
        return false;
    }

    public boolean addToList(String url) {

        if (checkIfUrlExists(url)) {


        } else {


            String content = getContentFromUrl(url);
            //cacheList.add(new Node(url,content, System.currentTimeMillis()));
        }
        return  false;
    }




    private String getContentFromUrl(String url) {
        String content = "";
        //makes a call to get the content and return json string..
        return content;

    }
}
