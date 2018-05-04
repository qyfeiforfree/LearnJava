package com.qyfei;

import java.util.Arrays;
/**
 * Created by qyfei on 2016-3-18.
 */
public class lession1 {
    public static void main(String [] args){
        System.out.println("HelloJava");
        double d = Math.random();
        System.out.println(d);
        for(int i = 0;i<=10;i++){
            System.out.println(i);
        }
        int[] a={5,4,2,4,9,1};
     /*   Arrays.sort(a);  //进行排序
        for(int i: a){
            System.out.print(i);
        }
        */
        for(int e =0;e<a.length-1;e++){
            for(int j= e+1;j<a.length;j++){
              if(a[e]<a[j]){
                int temp = a[e];
                a[e] = a[j];
                  a[j] = temp;
              }
            }
        }
        for(int k: a){
            System.out.print(k);
        }
      // System.out.println(a);
    }
}
