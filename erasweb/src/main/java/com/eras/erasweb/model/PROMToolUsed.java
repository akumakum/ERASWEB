package com.eras.erasweb.model;

public enum PROMToolUsed {
	SCORE_1(11),
    SCORE_2(9);
   
    private final int score;

    PROMToolUsed(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }
}
