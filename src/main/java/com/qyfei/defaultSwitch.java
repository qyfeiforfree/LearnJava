package com.qyfei;

public class defaultSwitch {
    public static void main(String [] args) {
        int a = 100;
        switch (a) {
            case 10:
                System.out.println(a);
                break;
            default:
                System.out.println("default");
        }
    }
}