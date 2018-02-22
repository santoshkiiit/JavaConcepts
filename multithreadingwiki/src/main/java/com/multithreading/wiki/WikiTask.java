package com.multithreading.wiki;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.ForkJoinTask;

/**
 * Created by santoshk on 2/8/18.
 */
public class WikiTask implements  Runnable {

    private final String USER_AGENT = "Mozilla/5.0";
    private final String directoryName ="/Users/santoshk/Projects/learning/JAVABASICS/final/JavaConcepts/output/";

    public WikiTask(String keyword) {
        this.keyword = keyword;
    }

    String keyword;
    static final String url = "https://en.wikipedia.org/w/api.php?format=json&action=query&prop=extracts&exintro=&explaintext=&titles&titles=";


    @Override
    public void run() {
        try {


            URL obj = new URL(url+keyword);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", USER_AGENT);

            int responseCode = con.getResponseCode();

            if (responseCode != 200) {
                throw new RuntimeException("fetch failed with response code:" + responseCode);
            }


            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();


            ObjectMapper mapper = new ObjectMapper();

            JsonNode rootNode = mapper.readTree(response.toString());

            List<String> desc = rootNode.findValuesAsText("extract");

            String desription = desc.get(0);
            this.writeToFile(desription);


        } catch (Exception e) {

        }
    }

    public Boolean writeToFile(String fileContent) {
        String fileName = keyword.replaceAll("\\s+","");
        fileName = keyword.replaceAll("/","");
        try {
            FileUtils.writeStringToFile(new File(directoryName,fileName + ".txt"), fileContent, "UTF-16");

        } catch (IOException e) {
          return false;
        }
        return true;


    }
}
