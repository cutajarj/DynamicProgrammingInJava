package com.cutajarjames.dynamicprogramming.recursion;

public class Timer {
    public void countDown(int seconds) throws InterruptedException {
        if (seconds < 0) return;
        System.out.println(seconds);
        Thread.sleep(1000);
        countDown(seconds - 1);
    }

    public static void main(String[] args) throws InterruptedException{
        (new Timer()).countDown(5);
    }
}
