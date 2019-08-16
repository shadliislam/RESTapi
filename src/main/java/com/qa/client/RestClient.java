package com.qa.client;

import org.apache.http.Header;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;

public class RestClient {

    //1. GEt Method
    public void get(String url) throws IOException {

        CloseableHttpClient httpClient =HttpClients.createDefault();  //createDefault() creates one client connection, and will return one closable httpClient object
        HttpGet httpGet=new HttpGet(url); //http get request
        CloseableHttpResponse closeableHttpResponse=httpClient.execute(httpGet); //hit the get url and will return one closable http object

        //a. Status Code
        int statusCode=closeableHttpResponse.getStatusLine().getStatusCode(); //return one integer
        System.out.println("Status Code---> "+statusCode);

        //b. JSON String
        String responseString=EntityUtils.toString(closeableHttpResponse.getEntity(),"UTF-8"); //will transfer the response msg into a string datatype

        JSONObject responseJson=new JSONObject(responseString);  //converts string response to JSON format
        System.out.println("Response JSON from API-->" +responseJson);

        //c. All Headers
        Header[] headerArray=closeableHttpResponse.getAllHeaders();   //one array with all the headers
        HashMap<String,String> allHeaders=new HashMap<String,String>();

        for(Header header:headerArray){
            allHeaders.put(header.getName(),header.getValue());
        }


        System.out.println("Headers Array--> "+allHeaders);
    }
}
