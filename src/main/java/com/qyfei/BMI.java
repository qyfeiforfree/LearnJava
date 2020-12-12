package com.qyfei;

public class BMI {
    public static void main(String[] args) {
        int weight = 100;
        double high = 1.8;
        double bmi = (double) weight / Math.pow(high, 2);
        System.out.println(bmi);
        if (bmi < 18.5) {
            System.out.println("体重过轻");
        } else if (bmi >= 18.5 && bmi < 25) {
            System.out.println("体重正常");
        } else if (bmi >= 25 && bmi < 28) {
            System.out.println("体重过重");
        } else if (bmi >= 28 && bmi < 32) {
            System.out.println("体重肥胖");
        } else {
            System.out.println("非常肥胖");
        }
    }
}
