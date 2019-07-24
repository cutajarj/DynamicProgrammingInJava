package com.cutajarjames.dynamicprogramming.countingderangements;

public class CountDerangementsRec {
    private int setSize;
    public CountDerangementsRec(int setSize) {
        this.setSize = setSize;
    }

    public long countDerangements() {
        return countDerangements(setSize);
    }

    private long countDerangements(int n) {
        if (n == 1) return 0;
        if (n == 2) return 1;
        return (n - 1) * (countDerangements(n - 1) + countDerangements(n - 2));
    }

    public static void main(String args[]) {
        for (int i = 1; i <= 20; i ++)
            System.out.println(new CountDerangementsRec(i).countDerangements());

//        new CountDerangementsRec(64).countDerangements();
//        System.out.println("Done");
    }
}
