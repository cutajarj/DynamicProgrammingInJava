package com.cutajarjames.dynamicprogramming.strdistance;

import java.util.Arrays;
import java.util.Collections;

public class StringDistanceTopDown {
    private String strA;
    private String strB;
    private int[][] dist;

    public StringDistanceTopDown(String strA, String strB) {
        this.strA = strA;
        this.strB = strB;
        this.dist = new int[strA.length() + 1][strB.length() + 1];
        for (int[] row : this.dist)
            Arrays.fill(row, -1);
    }

    public int distance() {
        return distance(strA.length(), strB.length());
    }

    private int distance(int a, int b) {
        if (this.dist[a][b] != -1) return this.dist[a][b];

        if (a == 0) return b;
        if (b == 0) return a;

        int replaceCost = strA.charAt(a - 1) == strB.charAt(b - 1) ? 0 : 1;

        int costDelete = distance(a - 1, b) + 1;
        int costInsert = distance(a, b - 1) + 1;
        int costReplace = distance(a - 1, b - 1) + replaceCost;

        int minCost = Collections.min(Arrays.asList(costDelete, costInsert, costReplace));
        this.dist[a][b] = minCost;
        return minCost;
    }

    public static void main(String[] args) {
        //StringDistanceTopDown strD = new StringDistanceTopDown("TodayIsSaturday", "TomorrowIsSunday");
        StringDistanceTopDown strD = new StringDistanceTopDown("Saturday", "Sundays");
        System.out.println(strD.distance());
    }
}
