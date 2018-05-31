package com.qyfei;

import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.lang.Math;


public class FileNameTest {
    public static void main(String[] args) {
        // Java文件名
        String fileName = "FileNameTest.java";
        // 邮箱
        String email = "laurenyang@imooc.com";

        // 判断.java文件名是否正确：合法的文件名应该以.java结尾
        /*
        参考步骤：
        1、获取文件名中最后一次出现"."号的位置
        2、根据"."号的位置，获取文件的后缀
        3、判断"."号位置及文件后缀名
        */
        //获取文件名中最后一次出现"."号的位置
        int index = fileName.lastIndexOf('.');
        //System.out.println(index);
        // 获取文件的后缀
        String prefix = fileName.substring(fileName.length() - 4);
        //System.out.println(prefix);
        // 判断必须包含"."号，且不能出现在首位，同时后缀名为"java"
        if (prefix.equals("java") && index != -1) {
            System.out.println("Java文件名正确");
        } else {
            System.out.println("Java文件名无效");
        }

        // 判断邮箱格式是否正确：合法的邮箱名中至少要包含"@", 并且"@"是在"."之前
         /*
        参考步骤：
        1、获取文件名中"@"符号的位置
        2、获取邮箱中"."号的位置
        3、判断必须包含"@"符号，且"@"必须在"."之前
        */
        // 获取邮箱中"@"符号的位置
        int index2 = email.indexOf('@');

        // 获取邮箱中"."号的位置
        int index3 = email.indexOf('.');

        // 判断必须包含"@"符号，且"@"必须在"."之前
        if (index2 != -1 && index3 > index2) {
            System.out.println("邮箱格式正确");
        } else {
            System.out.println("邮箱格式无效");
        }

        String s = "aljlkdsflkjsadjfklhasdkjlflkajdflwoiudsafhaasdasd";

        // 出现次数
        int num = 0;

        // 循环遍历每个字符，判断是否是字符 a ，如果是，累加次数
        for (int i = 0; i < s.length(); i++) {
            // 获取每个字符，判断是否是字符a
            if (s.charAt(i) == 'a') {
                // 累加统计次数
                num++;
            }
        }
        System.out.println("字符a出现的次数：" + num);


        Calendar c = Calendar.getInstance();

        Date date = c.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String now = sdf.format(date);

        System.out.println("当前时间为：" + now);

        int[] nums = new int[10] ;

        //通过循环给数组赋值
        for (int i = 0; i < nums.length; i++) {
            // 产生10以内的随机数
            int x =(int)(Math.random()*10);

                    nums[i] = x;// 为元素赋值
        }

        // 使用foreach循环输出数组中的元素
        for (int n:nums) {
            System.out.println(n + " ");
        }
    }

}


