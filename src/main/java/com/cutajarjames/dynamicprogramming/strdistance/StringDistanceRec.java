package com.cutajarjames.dynamicprogramming.strdistance;

import java.util.Arrays;
import java.util.Collections;

public class StringDistanceRec {
    private String strA;
    private String strB;

    public StringDistanceRec(String strA, String strB) {
        this.strA = strA;
        this.strB = strB;
    }

    public int distance() {
        return distance(strA.length(), strB.length());
    }

    private int distance(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;

        int replaceCost = strA.charAt(a - 1) == strB.charAt(b - 1) ? 0 : 1;

        int costDelete = distance(a - 1, b) + 1;
        int costInsert = distance(a, b - 1) + 1;
        int costReplace = distance(a - 1, b - 1) + replaceCost;
        return Collections.min(Arrays.asList(costDelete, costInsert, costReplace));
    }

    public static void main(String[] args) {
        //StringDistanceRec strD = new StringDistanceRec("TodayIsSaturday", "TomorrowIsSunday");
        StringDistanceRec strD = new StringDistanceRec("Saturday", "Sundays");
        System.out.println(strD.distance());
    }
}
