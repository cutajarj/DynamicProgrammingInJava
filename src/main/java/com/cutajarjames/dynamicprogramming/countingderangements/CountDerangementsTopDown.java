package com.cutajarjames.dynamicprogramming.countingderangements;

import java.util.Arrays;

public class CountDerangementsTopDown {
    private int setSize;
    private long[] subSolutions;
    public CountDerangementsTopDown(int setSize) {
        this.setSize = setSize;
        this.subSolutions = new long[setSize + 1];
        Arrays.fill(this.subSolutions, -1);
    }

    public long countDerangements() {
        return countDerangements(setSize);
    }

    private long countDerangements(int i) {
        if (this.subSolutions[i] != -1) return this.subSolutions[i];
        if (i == 1) return 0;
        if (i == 2) return 1;
        long n = (i - 1) * (countDerangements(i - 1) + countDerangements(i -2));
        this.subSolutions[i] = n;
        return n;
    }

    public static void main(String args[]) {
        for (int i = 1; i <= 20; i ++)
            System.out.println(new CountDerangementsTopDown(i).countDerangements());

//        new CountDerangementsTopDown(64).countDerangements();
//        System.out.println("Done");
    }
}
