package com.multithreading.wiki;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * Created by santoshk on 2/6/18.
 */
public class WikiThread implements Callable<String> {

    private final String USER_AGENT = "Mozilla/5.0";
    private String searchString;
    private String url;

    @Override
    public String call() throws Exception {


            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", USER_AGENT);

            int responseCode = con.getResponseCode();

                if(responseCode!=200){
                    throw new RuntimeException("fetch failed with response code:"+ responseCode);
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


        return desription;

    }


    public WikiThread(String searchString , String url ) {
        this.searchString = searchString;
        this.url = url;
    }
}
