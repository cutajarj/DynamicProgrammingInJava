package com.cutajarjames.dynamicprogramming.countingderangements;

public class CountDerangementsOpt {
    private int setSize;
    private long solutionI = 0;

    public CountDerangementsOpt(int setSize) {
        this.setSize = setSize;
        long solutionIMinus2 = 0;
        long solutionIMinus1 = 1;
        for (int i = 1; i <= setSize; i++) {
            if (i == 1) solutionI = 0;
            else if (i == 2) solutionI = 1;
            else {
                solutionI = (i - 1) * (solutionIMinus1 + solutionIMinus2);
                solutionIMinus2 = solutionIMinus1;
                solutionIMinus1 = solutionI;
            }
        }
    }

    public long countDerangements() {
        return solutionI;
    }

    public static void main(String args[]) {
        for (int i = 1; i <= 20; i++)
            System.out.println(new CountDerangementsOpt(i).countDerangements());

//        new CountDerangementsTopDown(64).countDerangements();
//        System.out.println("Done");
    }
}
