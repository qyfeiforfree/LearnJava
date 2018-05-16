package com.qyfei;

import java.util.Arrays;

public class TestArrays {


public int[] getArrays(int lentgh){
   int[]nums = new int[lentgh];
for (int i =0;i<nums.length-1;i++){
    nums[i]=(int)(Math.random()*100);
}
return nums;
    }

    public static void main(String[] args) {
        TestArrays testArrays = new TestArrays();
        int[] nums = testArrays.getArrays(8);
        System.out.println(Arrays.toString(nums));
    }

}
