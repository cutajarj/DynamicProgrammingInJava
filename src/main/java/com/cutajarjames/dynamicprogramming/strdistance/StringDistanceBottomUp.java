package com.cutajarjames.dynamicprogramming.strdistance;

import java.util.Arrays;
import java.util.Collections;

public class StringDistanceBottomUp {
    private String strA;
    private String strB;
    private int[][] dist;

    public StringDistanceBottomUp(String strA, String strB) {
        this.strA = strA;
        this.strB = strB;
        this.dist = new int[strA.length() + 1][strB.length() + 1];

        for (int a = 0; a <= strA.length(); a++) {
            for (int b = 0; b <= strB.length(); b++) {
                if (a == 0) this.dist[a][b] = b;
                else if (b == 0) this.dist[a][b] = a;
                else {
                    int replaceCost = strA.charAt(a - 1) == strB.charAt(b - 1) ? 0 : 1;
                    int costDelete = this.dist[a - 1][b] + 1;
                    int costInsert = this.dist[a][b - 1] + 1;
                    int costReplace = this.dist[a - 1][b - 1] + replaceCost;
                    this.dist[a][b] = Collections.min(Arrays.asList(costDelete, costInsert, costReplace));
                }
            }
            System.out.println(Arrays.toString(dist[a]));
        }
    }

    public int distance() {
        return this.dist[strA.length()][strB.length()];
    }

    public static void main(String[] args) {
        //StringDistanceTopDown strD = new StringDistanceTopDown("TodayIsSaturday", "TomorrowIsSunday");
        StringDistanceBottomUp strD = new StringDistanceBottomUp("Saturday", "Sundays");
        System.out.println(strD.distance());
    }
}
