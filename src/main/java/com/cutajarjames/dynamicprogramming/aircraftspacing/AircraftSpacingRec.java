package com.cutajarjames.dynamicprogramming.aircraftspacing;

public class AircraftSpacingRec {
    private int[] passengers;

    public AircraftSpacingRec(int[] passengers) {
        this.passengers = passengers;
    }

    public int maxpassengers(int i) {
        if (i >= passengers.length) return 0;
        int choosingFirst = passengers[i] + maxpassengers(i + 2);
        int notChoosingFirst = maxpassengers(i + 1);
        return Math.max(choosingFirst, notChoosingFirst);
    }

    public static void main(String[] args) {
        /*AircraftSpacingRec airSpacing = new AircraftSpacingRec(new int[]{155, 55, 2, 96, 67, 203, 3, 66, 32, 65,
                29, 8, 299, 323, 77, 3, 28, 128, 19, 523, 372, 2, 3, 66, 124, 38, 34, 12,88, 23 ,74,65, 87, 434,
                14, 7, 49, 38, 27, 641, 61, 58, 14, 57, 71, 11, 82, 178, 93, 191, 4});*/
        AircraftSpacingRec airSpacing = new AircraftSpacingRec(new int[]{155, 55, 2, 96, 67, 203, 3});
        System.out.println(airSpacing.maxpassengers(0));
    }
}
