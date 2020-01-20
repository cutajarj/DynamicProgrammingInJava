package com.cutajarjames.dynamicprogramming.countingderangements;

public class CountDerangementsBottomUp {
    private int setSize;
    private long[] subSolutions;
    public CountDerangementsBottomUp(int setSize) {
        this.setSize = setSize;
        this.subSolutions = new long[setSize + 1];
        for (int n = 1; n <= setSize; n++) {
            if (n == 1) subSolutions[n] = 0;
            else if (n == 2) subSolutions[n] = 1;
            else
                subSolutions[n] = (n - 1) * (subSolutions[n - 1] + subSolutions[n - 2]);
        }
    }

    public long countDerangements() {
        return subSolutions[setSize];
    }

    public static void main(String args[]) {
        for (int i = 1; i <= 20; i++)
            System.out.println(new CountDerangementsBottomUp(i).countDerangements());
//        new CountDerangementsBottomUp(64).countDerangements();
//        System.out.println("Done");
    }
}
