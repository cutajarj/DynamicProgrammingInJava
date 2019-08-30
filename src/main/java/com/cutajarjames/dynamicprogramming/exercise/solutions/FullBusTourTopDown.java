package com.cutajarjames.dynamicprogramming.exercise.solutions;

import java.util.Arrays;

public class FullBusTourTopDown {
    private int[] groupSizes;
    private int fullCapacity;
    private Boolean[][] subSolutions;

    public FullBusTourTopDown(int[] groupSizes, int fullCap) {
        this.groupSizes = groupSizes;
        this.fullCapacity = fullCap;
        this.subSolutions = new Boolean[groupSizes.length + 1][fullCap + 1];
        for (Boolean[] row : subSolutions)
            Arrays.fill(row, null);
    }

    public boolean fitsExactly() {
        return fitsExactly(groupSizes.length, fullCapacity);
    }

    private boolean fitsExactly(int len, int c) {
        if (c == 0) return true;
        if (c < 0 || len == 0) return false;
        if (this.subSolutions[len][c] != null) return subSolutions[len][c];
        boolean fits = fitsExactly(len - 1, c) ||
                (c - groupSizes[len - 1] >= 0 && fitsExactly(len - 1, c - groupSizes[len - 1]));
        this.subSolutions[len][c] = fits;
        return fits;
    }
}
