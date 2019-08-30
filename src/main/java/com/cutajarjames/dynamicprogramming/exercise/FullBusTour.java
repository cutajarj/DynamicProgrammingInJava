package com.cutajarjames.dynamicprogramming.exercise;


/**
 * You are developing an online booking portal for a bus tour company. On the website, tourists can book in
 * groups to come on your company's city bus tour. The company has various buses with different capacities.
 * You want to determine, from the list of available bookings, if you can completely fill up a particular bus.
 * The golden rule is that you cannot break groups apart and put them on separate buses.
 * More formally:
 * <p>
 * For:
 * A bus with capacity: int c
 * A list of group bookings, where each element represents a group size: int groupSizes[]
 * Write a function that returns true iff groupSizes contains a subset that when you sum it up is equal to c.
 * That is from the list of group bookings you can completely fill up a bus
 * <p>
 * Assume:
 * capacity c is greater than 0
 * each integer in groupSizes is greater than 0
 * <p>
 * Examples:
 * groupSizes = {4, 13, 5, 12, 6, 1, 8},  c = 11 should return true as subset (5, 6) has a sum of 9
 * groupSizes = {1, 1, 1},  c = 3 should return true as subset (1, 1, 1) has a sum of 3
 * groupSizes = {4, 5, 6, 7},  c = 100 should return false
 */
public class FullBusTour {
    private int[] groupSizes;
    private int fullCapacity;

    public FullBusTour(int[] groupSizes, int fullCap) {
        this.groupSizes = groupSizes;
        this.fullCapacity = fullCap;
    }

    public boolean fitsExactly() {
        return false;
    }
}
