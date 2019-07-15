package com.cutajarjames.dynamicprogramming.maxsubarry;

import java.util.Arrays;

public class MaxSubArrayBottomUp {
    private int[] prices;
    private int[] subSolutions;

    public MaxSubArrayBottomUp(int[] prices) {
        this.prices = prices;
        subSolutions = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            if (i == 0) subSolutions[i] = prices[0];
            else subSolutions[i] = Math.max(prices[i], subSolutions[i - 1] + prices[i]);
        }
    }

    public int maxSubArray() {
        int max = 0;
        for (int subSolution : subSolutions) {
            max = Math.max(max, subSolution);
        }
        return max;
    }

    public static void main(String[] args) {
        MaxSubArrayBottomUp msa = new MaxSubArrayBottomUp(new int[]{5, -4, 8, -10, -2, 4, -3, 2, 7, -8, 3, -5, 3});
        System.out.println(msa.maxSubArray());

        /*int[] input = new int[30000];
        Arrays.fill(input, 1);
        for (int i = 0; i < 10; i++) {
            MaxSubArrayBottomUp msa = new MaxSubArrayBottomUp(input);
            System.out.println(msa.maxSubArray());
        }*/
    }
}
