package com.cutajarjames.dynamicprogramming.countingderangements;

public class CountDerangementsOpt {
    private int setSize;
    private long solutionN;
    public CountDerangementsOpt(int setSize) {
        this.setSize = setSize;
        long solutionNMinus2 = 0;
        long solutionNMinus1 = 0;
        for (int n = 1; n <= setSize; n++) {
            if (n == 1) solutionN = 0;
            else if (n == 2) solutionN = 1;
            else
                solutionN = (n - 1) * (solutionNMinus1 + solutionNMinus2);
            solutionNMinus2 = solutionNMinus1;
            solutionNMinus1 = solutionN;
        }
    }

    public long countDerangements() {
        return solutionN;
    }

    public static void main(String args[]) {
        for (int i = 1; i <= 20; i++)
            System.out.println(new CountDerangementsOpt(i).countDerangements());

//        new CountDerangementsTopDown(64).countDerangements();
//        System.out.println("Done");
    }
}
