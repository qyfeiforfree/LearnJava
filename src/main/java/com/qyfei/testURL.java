package com.qyfei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class testURL {
    public static void main(String[] args) throws IOException {
        URL imooc = new URL("https://www.baidu.com");
        URL url = new URL(imooc, "/index.html");
        System.out.println(imooc.getProtocol());
        System.out.println(imooc.getHost());
        System.out.println(imooc.getPort());
        InputStream is = imooc.openStream();
        InputStreamReader isr = new InputStreamReader(is, "utf-8");
        BufferedReader br = new BufferedReader(isr);
        String data = br.readLine();
        while (data != null) {
            System.out.println(data);
            data = br.readLine();
        }
        br.close();
        isr.close();
        is.close();
    }
}
