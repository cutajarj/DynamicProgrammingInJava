package com.cutajarjames.dynamicprogramming.maxsubarry;

import java.util.Arrays;

public class MaxSubArrayTopDown {
    private int[] prices;
    private Integer[] subSolutions;

    public MaxSubArrayTopDown(int[] prices) {
        this.prices = prices;
        subSolutions = new Integer[prices.length];
        Arrays.fill(subSolutions, null);
    }

    public int maxSubArray() {
        int max = 0;
        for (int j = 0; j < prices.length; j++) {
            max = Math.max(max, this.maxSubArrayEndingAt(j));
        }
        return max;
    }

    public int maxSubArrayEndingAt(int i) {
        if (subSolutions[i] != null) return subSolutions[i];
        if (i == 0) return prices[0];
        int max = Math.max(prices[i], maxSubArrayEndingAt(i - 1) + prices[i]);
        subSolutions[i] = max;
        return max;
    }

    public static void main(String[] args) {
        MaxSubArrayTopDown msa = new MaxSubArrayTopDown(new int[]{5, -4, 8, -10, -2, 4, -3, 2, 7, -8, 3, -5, 3});
        System.out.println(msa.maxSubArray());
        /*
        int[] input = new int[30000];
        Arrays.fill(input, 1);
        for (int i = 0; i < 10; i ++) {
            MaxSubArrayTopDown msa = new MaxSubArrayTopDown(input);
            System.out.println(msa.maxSubArray());
        }
         */
    }
}
