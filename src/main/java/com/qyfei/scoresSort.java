package com.qyfei;

import java.util.Arrays;

public class scoresSort {
    public static void main(String[] args) {
        int[] scores = {89, -23, 64, 91, 119, 52, 73};
        scoresSort sS = new scoresSort();
        sS.getTop3(scores);
    }

    public void getTop3(int[] scores) {
        Arrays.sort(scores);
        int count = 0;
        System.out.println("top three is:");
        for (int i = scores.length - 1; i >= 0; i--) {
            if ((scores[i] < 0) || (scores[i] > 100)) continue;
            System.out.println(scores[i]);
            count++;
            if (count == 3) break;
        }
    }
}
