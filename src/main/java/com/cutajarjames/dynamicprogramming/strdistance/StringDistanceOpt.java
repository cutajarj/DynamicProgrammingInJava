package com.cutajarjames.dynamicprogramming.strdistance;

import java.util.Arrays;
import java.util.Collections;

public class StringDistanceOpt {
    private String strA;
    private String strB;
    private int[] dist1;
    private int[] dist2;

    public StringDistanceOpt(String strA, String strB) {
        this.strA = strA;
        this.strB = strB;
        this.dist1 = new int[strB.length() + 1];
        this.dist2 = new int[strB.length() + 1];

        for (int a = 0; a <= strA.length(); a++) {
            for (int b = 0; b <= strB.length(); b++) {
                if (a == 0) this.dist2[b] = b;
                else if (b == 0) this.dist2[b] = a;
                else {
                    int replaceCost = strA.charAt(a - 1) == strB.charAt(b - 1) ? 0 : 1;
                    int costDelete = this.dist1[b] + 1;
                    int costInsert = this.dist2[b - 1] + 1;
                    int costReplace = this.dist1[b - 1] + replaceCost;
                    this.dist2[b] = Collections.min(Arrays.asList(costDelete, costInsert, costReplace));
                }
            }
            int[] temp = dist1;
            dist1 = dist2;
            dist2 = temp;
        }
    }

    public int distance() {
        return this.dist1[strB.length()];
    }

    public static void main(String[] args) {
        //StringDistanceTopDown strD = new StringDistanceTopDown("TodayIsSaturday", "TomorrowIsSunday");
        StringDistanceOpt strD = new StringDistanceOpt("Saturday", "Sundays");
        System.out.println(strD.distance());
    }
}
