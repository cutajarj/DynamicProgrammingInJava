package com.cutajarjames.dynamicprogramming.aircraftspacing;

public class AircraftSpacingBottomUp {
    private int[] passengers;
    private int[] subSolutions;

    public AircraftSpacingBottomUp(int[] passengers) {
        this.passengers = passengers;
        this.subSolutions = new int[passengers.length];
        for (int i = passengers.length - 1; i >= 0; i--) {
            int choosingFirst = passengers[i] + (i + 2 < subSolutions.length ? subSolutions[i + 2] : 0);
            int notChoosingFirst = i + 1 < subSolutions.length ? subSolutions[i + 1] : 0;
            subSolutions[i] = Math.max(choosingFirst, notChoosingFirst);
        }
    }

    public int maxPassengers() {
        return subSolutions[0];
    }

    public static void main(String[] args) {
        /*AircraftSpacingBottomUp airSpacing = new AircraftSpacingBottomUp(new int[]{155, 55, 2, 96, 67, 203, 3, 66, 32, 65,
                29, 8, 299, 323, 77, 3, 28, 128, 19, 523, 372, 2, 3, 66, 124, 38, 34, 12,88, 23 ,74,65, 87, 434,
                14, 7, 49, 38, 27, 641, 61, 58, 14, 57, 71, 11, 82, 178, 93, 191, 4});*/
        AircraftSpacingBottomUp airSpacing = new AircraftSpacingBottomUp(new int[]{155, 55, 2, 96, 67, 203, 3});
        System.out.println(airSpacing.maxPassengers());
    }

}
