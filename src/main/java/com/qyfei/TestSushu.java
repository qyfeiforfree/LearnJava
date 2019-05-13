package com.qyfei;

import java.util.ArrayList;
import java.util.logging.Logger;

public class TestSushu {

    public static String TestStringMethod(String sa, String sb) {
        //String ss = sa + sb;
        // return ss;
        return sa + sb;
    }
    public static int TestIntMethod(){
        int a =10>3?1:0;
        return a;
    }
public static void method(int i){
        i++;
        System.out.println("Method ="+i);

}

    public static void main(String args[]) {


        Logger.getGlobal().info("Assert begin:");
        int a = 2;
        assert a >= 0 : a;
        Logger.getGlobal().info("Assert end");
        ArrayList<String> files = new ArrayList<String>();
        files.add("JAVA");
        String filename = files.get(0);
        Logger.getGlobal().info(filename);


        for (char c = 0; c < 126; c++) {
            if (c == 26) {
                continue;
            }
            System.out.println("Value :" + (int) c + " Character :" + c);
        }

        for (int i = 0; i <= 100; i++) {
            if (i == 47) break;
            Logger.getGlobal().info(String.valueOf(i));
        }
        System.out.println(TestStringMethod("String a ", " String b"));
        System.out.println(TestIntMethod());
        int i=10;
        method(i);
        System.out.println("Main="+i);
    }
}
