package com.cutajarjames.dynamicprogramming.justify;

public class TextJustifyRec {

    private String[] txt;
    private int lineLength;

    public TextJustifyRec(String[] txt, int lineLength) {
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

    public int format(int i) {
        if (i == txt.length) return 0;
        int score = Integer.MAX_VALUE;
        for (int x = i + 1; x <= txt.length; x++) {
            int lineLen = countChars(i, x);
            long currScore = uglyScore(lineLen);
            currScore += format(x);
            score = (int) Math.min(currScore, score);
        }
        return score;
    }

    public static void main(String[] args) {
        TextJustifyRec j = new TextJustifyRec("Isabel sat on the step".split(" "), 10);
        System.out.println(j.format(0));
    }
}
