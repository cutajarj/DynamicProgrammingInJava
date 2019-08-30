package com.cutajarjames.dynamicprogramming.exercise.solutions;

public class FullBusTourRec {
    private int[] groupSizes;
    private int fullCapacity;

    public FullBusTourRec(int[] groupSizes, int fullCap) {
        this.groupSizes = groupSizes;
        this.fullCapacity = fullCap;
    }

    public boolean fitsExactly() {
        return fitsExactly(groupSizes.length, fullCapacity);
    }

    private boolean fitsExactly(int len, int c) {
        if (c == 0) return true;
        if (len == 0) return false;
        return fitsExactly(len - 1, c) ||
                (c - groupSizes[len - 1] >= 0 && fitsExactly(len - 1, c - groupSizes[len - 1]));
    }
}
