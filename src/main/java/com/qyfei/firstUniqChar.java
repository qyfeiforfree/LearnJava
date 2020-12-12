package com.qyfei;

import java.util.Arrays;

public class firstUniqChar {
    public static char firstUniqChar(String s) {
        int[] count = new int[256];
        char[] chars = s.toCharArray();
        for (char c : chars) {
            count[c]++;
        }
        for (char c : chars) {
            if (count[c] == 1)
                return c;
        }
        return ' ';
    }

    public int romanToInt(String s) {
        int sum = 0;
        int preNum = getValue(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            int num = getValue(s.charAt(i));
            if (preNum < num) {
                sum -= preNum;
            } else {
                sum += preNum;
            }
            preNum = num;
        }
        sum += preNum;
        return sum;
    }

    private int getValue(char ch) {
        switch (ch) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }


    public static boolean repeatedSubstringPattern(String s) {
        // System.out.println((s + s).indexOf(s, 1));
        return (s + s).indexOf(s, 1) != s.length();
    }

    public static int[] sortArray(int [] array){
        int temp=0;
        for(int i=0;i<array.length-1;i++){
            for (int j=0;j<array.length-1-i;j++)
                if(array[j+1]<array[j]){
                    temp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                }
        }
return array;
    }
    public static void main(String args[]) {
        String s = "asdkajdlwewjkslegdsg";
         char c = firstUniqChar(s);
        System.out.print(c);
        String A = "abcdabcd";
        boolean bool = repeatedSubstringPattern(A);
        System.out.println(bool);
        int[] array={1,2,4,7,6,3,9,23,5,32};
        int[] a=sortArray(array);
        System.out.println(Arrays.toString(a));
    }
}
