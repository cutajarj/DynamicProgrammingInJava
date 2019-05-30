package com.cutajarjames.dynamicprogramming.justify;

import java.util.Arrays;

public class TextJustifyDyn {
    private String[] txt;
    private int lineLength;

    public TextJustifyDyn(String[] txt, int lineLength) {
        this.txt = txt;
        this.lineLength = lineLength;
    }

    public int uglyScore(int txtLength) {
        return txtLength <= lineLength ? (int) Math.pow(lineLength - txtLength, 2) : Integer.MAX_VALUE;
    }

    public int countChars(int from, int to) {
        int totalChars = 0;
        for (int i = from; i < to; i++) {
            totalChars += txt[i].length();
            if (i < to - 1) totalChars++;
        }
        return totalChars;
    }

    public int format() {
        int[] scores = new int[txt.length + 1];
        int[] ptrs = new int[txt.length];
        scores[txt.length] = 0;

        for (int i = txt.length - 1; i >= 0; i--) {
            int score = Integer.MAX_VALUE;
            for (int j = i + 1; j <= txt.length; j++) {
                long currScore = (long) uglyScore(countChars(i, j)) + scores[j];
                if (currScore < score) {
                    score = (int) currScore;
                    ptrs[i] = j;
                }
            }
            scores[i] = score;
        }

        printTxt(ptrs);
        return scores[0];
    }

    public void printTxt(int[] ptrs) {
        int i = 0;
        while (i < ptrs.length - 1) {
            String[] line = Arrays.copyOfRange(txt, i, ptrs[i]);
            System.out.println(String.join(" ", line));
            i = ptrs[i];
        }
    }


    public static void main(String[] args) {
        //TextJustifyDyn j = new TextJustifyDyn("The actual Enumeration shall be made within three Years after the first Meeting of the Congress of the United States, and within every subsequent Term of ten Years, in such Manner as they shall by Law direct. The Number of Representatives shall not exceed one for every thirty Thousand, but each State shall have at Least one Representative; and until such enumeration shall be made, the State of New Hampshire shall be entitled to chuse three, Massachusetts eight, Rhode-Island and Providence Plantations one, Connecticut five, New-York six, New Jersey four, Pennsylvania eight, Delaware one, Maryland six, Virginia ten, North Carolina five, South Carolina five, and Georgia three.".split(" "), 67);
        TextJustifyDyn j = new TextJustifyDyn("Isabel sat on the step".split(" "), 10);
        System.out.println(j.format());
    }
}
