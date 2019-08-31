package com.cutajarjames.dynamicprogramming.exercisesolutions;

import com.cutajarjames.dynamicprogramming.exercise.FullBusTour;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class FullBusTourTest {

    @Test
    public void testSimpleBusFull() {
        boolean result = new FullBusTour(new int[]{3, 34, 4, 12, 5, 2}, 9).fitsExactly();
        Assert.assertTrue("{3, 34, 4, 12, 5, 2} with a bus capacity of 9 should fit with {4, 5}", result);
    }

    @Test
    public void testSimpleBusFullAgain() {
        boolean result = new FullBusTour(new int[]{3, 34, 4, 12, 5, 2}, 10).fitsExactly();
        Assert.assertTrue("{3, 34, 4, 12, 5, 2} with a bus capacity of 10 should fit with {3, 5, 2}", result);
    }

    @Test
    public void testSmallBusNonFull() {
        boolean result = new FullBusTour(new int[]{3, 34, 4, 12, 5, 2}, 1).fitsExactly();
        Assert.assertFalse("{3, 34, 4, 12, 5, 2} with a bus capacity of 1 should not fit", result);
    }

    @Test
    public void testOnesTwosBusNonFull() {
        boolean result = new FullBusTour(new int[]{1, 2, 5, 8, 7, 12}, 4).fitsExactly();
        Assert.assertFalse("{1, 2, 5, 8, 7, 12} with a bus capacity of 4 should not fit", result);
    }

    @Test
    public void testEvenOnlyBusNonFull() {
        boolean result = new FullBusTour(new int[]{2, 4, 2, 8, 6, 4, 10, 6}, 21).fitsExactly();
        Assert.assertFalse("{2, 4, 2, 8, 6, 4, 10, 6} with a bus capacity of 21 should not fit", result);
    }

    @Test
    public void testOddOnlyBusFull() {
        boolean result = new FullBusTour(new int[]{1, 3, 5, 1, 7, 11, 9, 9}, 21).fitsExactly();
        Assert.assertTrue("{1, 3, 5, 1, 7, 11, 9, 9} with a bus capacity of 21 should fit with {11, 9, 1}", result);
    }

    @Test
    public void testBigBusFull() {
        boolean result = new FullBusTour(new int[]{1, 3, 5, 4, 7, 11, 9, 9, 21, 7, 4, 21, 13, 8, 2, 5, 1, 18}, 107).fitsExactly();
        Assert.assertTrue("{1, 3, 5, 4, 7, 11, 9, 9, 21, 7, 4, 21, 13, 8, 2, 5, 1, 18} with a bus capacity of 107 should fit", result);
    }

    @Test
    public void testPerfTest() {
        int[] bookings = new int[500];
        Arrays.fill(bookings, 1);
        boolean result = new FullBusTour(bookings, 500).fitsExactly();
        Assert.assertTrue("Performance test is failing. Improve your algorithm!", result);
    }
}
