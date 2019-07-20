package com.cutajarjames.dynamicprogramming.maxsubarry;

import java.util.Arrays;

public class MaxSubArrayRec {
    private int[] prices;

    public MaxSubArrayRec(int[] prices) {
        this.prices = prices;
    }

    public int maxSubArray() {
        int max = 0;
        for (int j = 0; j < prices.length; j++) {
            max = Math.max(max, this.maxSubArrayEndingAt(j));
        }
        return max;
    }

    public int maxSubArrayEndingAt(int i) {
        if (i == 0) return prices[0];
        return Math.max(prices[i], maxSubArrayEndingAt(i - 1) + prices[i]);
    }

    public static void main(String[] args) {
        MaxSubArrayRec rec = new MaxSubArrayRec(new int[]{5, -4, 8, -10, -2, 4, -3, 2, 7, -8, 3, -5, 3});
        System.out.println(rec.maxSubArray());
        /*
        int[] input = new int[30000];
        Arrays.fill(input, 1);
        for (int i = 0; i < 10; i ++) {
            MaxSubArrayRec msa = new MaxSubArrayRec(input);
            System.out.println(msa.maxSubArray());
        }
        */
    }
}
