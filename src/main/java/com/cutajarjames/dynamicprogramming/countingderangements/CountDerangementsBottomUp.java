package com.cutajarjames.dynamicprogramming.countingderangements;

import java.util.Arrays;

public class CountDerangementsBottomUp {
    private int setSize;
    private long[] subSolutions;

    public CountDerangementsBottomUp(int setSize) {
        this.setSize = setSize;
        this.subSolutions = new long[setSize + 1];
        for (int i = 1; i <= setSize; i++) {
            if (i == 1) subSolutions[i] = 0;
            else if (i == 2) subSolutions[i] = 1;
            else
                this.subSolutions[i] = (i - 1) * (this.subSolutions[i - 1] + this.subSolutions[i - 2]);
        }
    }

    public long countDerangements() {
        return subSolutions[setSize];
    }

    public static void main(String args[]) {
        for (int i = 1; i <= 20; i++)
            System.out.println(new CountDerangementsBottomUp(i).countDerangements());

//        new CountDerangementsTopDown(64).countDerangements();
//        System.out.println("Done");
    }
}
