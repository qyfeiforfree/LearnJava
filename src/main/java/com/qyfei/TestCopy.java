package com.qyfei;

import java.io.*;
import java.time.*;

public class TestCopy {
    public static void main(String[] atgs) throws IOException {
        try (InputStream input = new FileInputStream("/Users/qiyanfei/Downloads/action.txt")) {
            // 定义1000个字节大小的缓冲区:
            byte[] buffer = new byte[1000];
            int n;
            while ((n = input.read(buffer)) != -1) { // 读取到缓冲区
                System.out.println("read " + n + " bytes.");
            }
        }

        try (InputStream input = new FileInputStream("/Users/qiyanfei/Downloads/action.txt");
             OutputStream output = new FileOutputStream("/Users/qiyanfei/Downloads/copy.txt")) {
            byte[] buffer = new byte[1000];
            int len;
            while ((len = input.read(buffer)) != -1) {
                output.write(buffer, 0, len);
            }
            System.out.println("Copy finish ");
        }
 /*
        LocalDateTime dateTime= new LocalDateTime.now();

         LocalDate date=dateTime.toLocalDate();
        LocalTime time = dateTime.toLocalTime();
        System.out.println(date);
        System.out.println(time);
        System.out.println(dateTime);

         ZonedDateTime zbj=new ZonedDateTime.now(ZoneId.of("Asia/Shanghai"));
       */
        LocalDateTime time = LocalDateTime.of(2020, Month.NOVEMBER, 21, 17, 20, 45);
        System.out.println(time);


        Instant now = Instant.now();
        System.out.println(now.getEpochSecond());
        System.out.println(now.toEpochMilli());
        String reg = "20\\d\\d";
        System.out.println("2020".matches(reg));
        System.out.println("1020".matches(reg));

        Thread myThread = new myThread();
        myThread.start();

        Thread thread = new Thread();

    }
}
class myThread extends Thread{
    @Override
    public void run() {
        System.out.println("Start new  thread !");
    }
}