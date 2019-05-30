package com.cutajarjames.dynamicprogramming.justify;

import java.util.Arrays;

public class TextJustifyDynOpt {
    private String[] txt;
    private int[][] wordLengths;
    private int lineLength;

    public TextJustifyDynOpt(String[] txt, int lineLength) {
        this.txt = txt;
        this.lineLength = lineLength;
        wordLengths = new int[txt.length][txt.length];
        for (int i = 0; i < txt.length; i++) {
            wordLengths[i][i] = txt[i].length();
            for (int j = i + 1; j < txt.length; j++) {
                wordLengths[i][j] = wordLengths[i][j - 1] + 1 + txt[j].length();
            }
        }
        for (int[] arr : wordLengths)
            System.out.println(Arrays.toString(arr));
    }

    public int uglyScore(int txtLength) {
        return txtLength <= lineLength ? (int) Math.pow(lineLength - txtLength, 2) : Integer.MAX_VALUE;
    }

    public int format() {
        int[] scores = new int[txt.length + 1];
        int[] ptrs = new int[txt.length];
        scores[txt.length] = 0;

        for (int i = txt.length - 1; i >= 0; i--) {
            int score = Integer.MAX_VALUE;
            for (int j = i + 1; j <= txt.length; j++) {
                long currScore = (long) uglyScore(wordLengths[i][j - 1]) + scores[j];
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
        //TextJustifyDynOpt j = new TextJustifyDynOpt("The actual Enumeration shall be made within three Years after the first Meeting of the Congress of the United States, and within every subsequent Term of ten Years, in such Manner as they shall by Law direct. The Number of Representatives shall not exceed one for every thirty Thousand, but each State shall have at Least one Representative; and until such enumeration shall be made, the State of New Hampshire shall be entitled to chuse three, Massachusetts eight, Rhode-Island and Providence Plantations one, Connecticut five, New-York six, New Jersey four, Pennsylvania eight, Delaware one, Maryland six, Virginia ten, North Carolina five, South Carolina five, and Georgia three.".split(" "), 67);
        TextJustifyDynOpt j = new TextJustifyDynOpt("Isabel sat on the step".split(" "), 10);
        System.out.println(j.format());
    }

}
