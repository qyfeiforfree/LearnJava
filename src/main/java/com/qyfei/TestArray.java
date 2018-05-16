package com.qyfei;

import java.util.Arrays;

public class TestArray {

    // 调用方法
    public static void showMyLove() {
        System.out.println("我爱慕课网!");
    }

    public static double calcAvg() {
        double java = 92.5;
        double php = 83.0;
        double avg = (java + php) / 2;
        return avg;

    }

    public int getMaxAge() {
        int[] ages = {18, 23, 21, 19, 25, 29, 17};
        int max = ages[0];
        for (int i = 0; i < ages.length - 1; i++) {
            if (max < ages[i]) {
                max = ages[i];
            }
        }
        return max;
    }
    public int sort(int[] scores){
        Arrays.sort(scores);
        System.out.println(Arrays.toString(scores));
        int lenth = scores.length;
        return lenth;
    }


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
        // 创建对象，对象名为hello
        TestArray hello = new TestArray();
        hello.showMyLove();
        //showMyLove();
        //double avg=hello.calcAvg();
        double avg = calcAvg();
        System.out.println("The avg is：" + avg);
        int maxAge = hello.getMaxAge();

        System.out.println("The Max age is：" + maxAge);
        int count=hello.sort(scores);
        System.out.println(count);
    }

}
