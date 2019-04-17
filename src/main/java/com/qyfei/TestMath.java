package com.qyfei;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;
import java.nio.file.Paths;

public class TestMath {
    public static void main(String args[]) throws IOException {
        double x = Math.pow(2, 6);
        System.out.println(x);
        String s = "123456";
        int a = Integer.valueOf(s);
        System.out.println(s);
        String as = s.substring(1, 3);
        System.out.println(as);
        String greeting = "Hello";
        String help = greeting.substring(0, 3) + "p！";
        System.out.println(help);
        double e = 10000.0 / 3.0;
        System.out.printf("%,6.5f", e);
        int f = 14;
        System.out.println();
        System.out.printf("%d", f);

        System.out.println();
        System.out.printf("%x", f);

        System.out.println();
        System.out.printf("%o", f);
        File file = new File("D:\\passwd.txt");

        //Scanner input = new Scanner(file);
        Scanner input = new Scanner(Paths.get("D:\\passwd.txt"));
        while (input.hasNext()) {
            String ss = input.nextLine();
            System.out.println(ss);
        }
        PrintWriter out = new PrintWriter(file);
        out.write("Test Write");
        out.close();

        int[] array = new int[10];
        array[0] = 5;
        int[] copyarray = Arrays.copyOf(array, array.length);
        for (int ca : copyarray
        ) {
            System.out.println(ca);
        }
        Arrays.sort(array);

        for (int ba : array) {
            System.out.println(ba);
        }
        int search = Arrays.binarySearch(array, 5);
        System.out.println(search);
        String ss = Arrays.toString(array);
        System.out.println(ss);
        Arrays.fill(array, 6);
        for (int fa : array) {
            System.out.println(fa);
        }


    }
}
/**

 @return true or false
 @throws IOException
        */
class Card{
    String name;
    int CardNo;
    Date date;

    public boolean getCardvalid(Date data){
        Date now = new Date();

        return true;
    }
        }

