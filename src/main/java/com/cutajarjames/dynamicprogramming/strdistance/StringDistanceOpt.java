package com.cutajarjames.dynamicprogramming.strdistance;

import java.util.Arrays;
import java.util.Collections;

public class StringDistanceOpt {
    private String strA;
    private String strB;
    private int[] distRead;
    private int[] distWrite;

    public StringDistanceOpt(String strA, String strB) {
        this.strA = strA;
        this.strB = strB;
        this.distRead = new int[strB.length() + 1];
        this.distWrite = new int[strB.length() + 1];

        for (int a = 0; a <= strA.length(); a++) {
            for (int b = 0; b <= strB.length(); b++) {
                if (a == 0) this.distWrite[b] = b;
                else if (b == 0) this.distWrite[b] = a;
                else {
                    int replaceCost = strA.charAt(a - 1) == strB.charAt(b - 1) ? 0 : 1;
                    int costDelete = this.distRead[b] + 1;
                    int costInsert = this.distWrite[b - 1] + 1;
                    int costReplace = this.distRead[b - 1] + replaceCost;
                    this.distWrite[b] = Collections.min(Arrays.asList(costDelete, costInsert, costReplace));
                }
            }
            int[] temp = distRead;
            distRead = distWrite;
            distWrite = temp;
            System.out.println(Arrays.toString(distRead));
        }
    }

    public int distance() {
        return this.distRead[strB.length()];
    }

    public static void main(String[] args) {
        //StringDistanceTopDown strD = new StringDistanceTopDown("TodayIsSaturday", "TomorrowIsSunday");
        StringDistanceOpt strD = new StringDistanceOpt("Saturday", "Sundays");
        System.out.println(strD.distance());
    }
}
