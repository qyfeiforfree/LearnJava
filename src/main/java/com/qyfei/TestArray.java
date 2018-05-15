package com.qyfei;

import java.util.Arrays;

public class TestArray {
    public static void main(String[] args) {
        int[] scores = {89, 72, 64, 58, 93};
        Arrays.sort(scores);
        for (int score : scores) {
            System.out.println(score);
        }
        String[][] names = {{"tom", "jack", "mike"}, {"zhangsan", "lisi", "wangwu"}};
        for (int i = 0; i < names.length; i++) {
            for (int j = 0; j < names[i].length; j++) {
                System.out.println(names[i][j]);
            }
            System.out.println();
        }
        for (String[] i : names) {
            for (String j : i) {
                System.out.println(j);
            }
            System.out.println();
        }
    }
}
