package com.qyfei;

public class TestRecursion {
     private static  int index = 1;
    public static void dosome() {
        Utiltools.p("Dosome begin:");

        index++;
        dosome();
        Utiltools.p("Dosome end!");
    }
    public static void main(String[] args) {

        Utiltools.p("Main begin:");
        try {
            dosome();
        } catch (StackOverflowError e) {
            System.out.println(index);
        }
        Utiltools.p(sumNum(10000));
        Utiltools.p("Main end!");
    }



    public static int sumNum(int n) {
        if (n == 1) return 1;
        else return n + sumNum(n - 1);

    }
}

class caseTest {
    int StuID;
    String StudentName;

    public static boolean case1() {
        return true;
    }
}

