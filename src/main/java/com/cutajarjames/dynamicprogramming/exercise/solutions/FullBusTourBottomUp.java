package com.cutajarjames.dynamicprogramming.exercise.solutions;

public class FullBusTourBottomUp {
    private int[] groupSizes;
    private int fullCapacity;
    private Boolean[][] subSolutions;

    public FullBusTourBottomUp(int[] groupSizes, int fullCap) {
        this.groupSizes = groupSizes;
        this.fullCapacity = fullCap;
        this.subSolutions = new Boolean[groupSizes.length + 1][fullCap + 1];
        for (int len = 0; len <= groupSizes.length; len++) {
            for (int c = 0; c <= fullCap; c++) {
                if (c == 0) subSolutions[len][c] = true;
                else if (len == 0) subSolutions[len][c] = false;
                else
                    subSolutions[len][c] = subSolutions[len - 1][c] ||
                            (c - groupSizes[len - 1] >= 0 && subSolutions[len - 1][c - groupSizes[len - 1]]);
            }
        }
    }

    public boolean fitsExactly() {
        return subSolutions[groupSizes.length][fullCapacity];
    }

}
