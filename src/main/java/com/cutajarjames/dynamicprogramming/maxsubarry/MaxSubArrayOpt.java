package com.cutajarjames.dynamicprogramming.maxsubarry;

import java.util.Arrays;

public class MaxSubArrayOpt {
    private int[] prices;
    private int maxGlobal;

    public MaxSubArrayOpt(int[] prices) {
        this.prices = prices;
        maxGlobal = 0;
        int maxLocal = 0;
        for (int i = 0; i < prices.length; i++) {
            if (i == 0) maxLocal = prices[0];
            else maxLocal = Math.max(prices[i], maxLocal + prices[i]);
            maxGlobal = Math.max(maxGlobal, maxLocal);
        }
    }

    public int maxSubArray() {
        return maxGlobal;
    }

    public static void main(String[] args) {
        MaxSubArrayOpt msa = new MaxSubArrayOpt(new int[]{5, -4, 8, -10, -2, 4, -3, 2, 7, -8, 3, -5, 3});
        System.out.println(msa.maxSubArray());
        /*
        int[] input = new int[30000];
        Arrays.fill(input, 1);
        for (int i = 0; i < 10; i ++) {
            MaxSubArrayOpt msa = new MaxSubArrayOpt(input);
            System.out.println(msa.maxSubArray());
        }
         */
    }
}
