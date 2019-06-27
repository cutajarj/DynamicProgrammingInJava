package com.cutajarjames.dynamicprogramming.aircraftspacing;

import java.util.Arrays;

public class AircraftSpacingTopDown {
    private int[] passangers;
    private int[] subSolutions;

    public AircraftSpacingTopDown(int[] passangers) {
        this.passangers = passangers;
        this.subSolutions = new int[passangers.length];
        Arrays.fill(subSolutions, -1);
    }

    public int maxPassangers(int i) {
        if (i >= passangers.length) return 0;
        if (subSolutions[i] != -1) return subSolutions[i];
        int choosingFirst = passangers[i] + maxPassangers(i + 2);
        int notChoosingFirst = maxPassangers(i + 1);
        int maxPass = Math.max(choosingFirst, notChoosingFirst);
        subSolutions[i] = maxPass;
        return maxPass;
    }

    public static void main(String[] args) {
        /*AircraftSpacingTopDown airSpacing = new AircraftSpacingTopDown(new int[]{155, 55, 2, 96, 67, 203, 3, 66, 32, 65,
                29, 8, 299, 323, 77, 3, 28, 128, 19, 523, 372, 2, 3, 66, 124, 38, 34, 12,88, 23 ,74,65, 87, 434,
                14, 7, 49, 38, 27, 641, 61, 58, 14, 57, 71, 11, 82, 178, 93, 191, 4});*/
        AircraftSpacingTopDown airSpacing = new AircraftSpacingTopDown(new int[]{155, 55, 2, 96, 67, 203, 3});
        System.out.println(airSpacing.maxPassangers(0));
    }
}
