package com.cutajarjames.dynamicprogramming.aircraftspacing;

public class AircraftSpacingOpt {
    private int[] passengers;
    private int subSolutionI = 0, subSolutionIPlusOne = 0, subSolutionIPlusTwo = 0;

    public AircraftSpacingOpt(int[] passengers) {
        this.passengers = passengers;
        for (int i = passengers.length - 1; i >= 0; i--) {
            int choosingFirst = passengers[i] + subSolutionIPlusTwo;
            int notChoosingFirst = subSolutionIPlusOne;
            subSolutionI = Math.max(choosingFirst, notChoosingFirst);
            subSolutionIPlusTwo = subSolutionIPlusOne;
            subSolutionIPlusOne = subSolutionI;
        }
    }

    public int maxPassengers() {
        return subSolutionI;
    }

    public static void main(String[] args) {
        AircraftSpacingOpt airSpacing = new AircraftSpacingOpt(new int[]{155, 55, 2, 96, 67, 203, 3, 66, 32, 65,
                29, 8, 299, 323, 77, 3, 28, 128, 19, 523, 372, 2, 3, 66, 124, 38, 34, 12,88, 23 ,74,65, 87, 434,
                14, 7, 49, 38, 27, 641, 61, 58, 14, 57, 71, 11, 82, 178, 93, 191, 4});
        //AircraftSpacingOpt airSpacing = new AircraftSpacingOpt(new int[]{155, 55, 2, 96, 67, 203, 3});
        System.out.println(airSpacing.maxPassengers());
    }
}
