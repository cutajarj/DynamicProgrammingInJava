package com.cutajarjames.dynamicprogramming.countingderangements;

public class CountDerangementsRec {
    private int setSize;
    public CountDerangementsRec(int setSize) {
        this.setSize = setSize;
    }

    public long countDerangements() {
        return countDerangements(setSize);
    }

    private long countDerangements(int i) {
        if (i == 1) return 0;
        if (i == 2) return 1;
        return (i - 1) * (countDerangements(i - 1) + countDerangements(i -2));
    }

    public static void main(String args[]) {
        for (int i = 1; i <= 20; i ++)
            System.out.println(new CountDerangementsRec(i).countDerangements());

//        new CountDerangementsRec(64).countDerangements();
//        System.out.println("Done");
    }
}
