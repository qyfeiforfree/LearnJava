package com.qyfei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
/**
 * Created by qyfei on 2016-3-18.
 */
public class TestHTTPRequest {

    /**
     * @param args
     * @throws IOException
     * @throws ClientProtocolException
     */
    public static void main(String[] args) throws ClientProtocolException, IOException
    {
        // 创建HttpClient实例
     String url = "http://172.28.38.63:6005/";
        HttpClient httpclient = new DefaultHttpClient();
        // 创建Get方法实例
       HttpGet httpgets = new HttpGet(url);

        HttpResponse response = httpclient.execute(httpgets);
        HttpEntity entity = response.getEntity();
        if (entity != null) {
            InputStream instreams = entity.getContent();
            String str = convertStreamToString(instreams);
            System.out.println("Do something");
            System.out.println(str);
            // Do not need the rest
            int len = str.length();
            System.out.println(len);
            httpgets.abort();
        }
        /*
        HttpPost httpposts = new HttpPost("http://localhost:8080/");
        HttpResponse responsepost = httpclient.execute(httpposts);
        HttpEntity entitypost = responsepost.getEntity();
        if (entitypost != null) {
            InputStream instreamspost = entitypost.getContent();
            String strpost = convertStreamToString(instreamspost);
            System.out.println("Do something");
            System.out.println(strpost);
            // Do not need the rest
            httpposts.abort();
         }
        */
    }

    public static String convertStreamToString(InputStream is) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }

}
