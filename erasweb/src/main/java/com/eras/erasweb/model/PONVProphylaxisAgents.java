package com.eras.erasweb.model;


public enum PONVProphylaxisAgents {
    SCORE_1(0),
    SCORE_2(1),
    SCORE_3(2);
    
    private final int score;

    PONVProphylaxisAgents(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }
}


//public enum PONVProphylaxisAgents {
//	 SCORE_1(0),
//     SCORE_2(1),
//     SCORE_3(2);
//    
//	private final int score;
//
//     PONVProphylaxisAgents(int score) {
//         this.score = score;
//     }
//
//     public int getScore() {
//         return score;
//     }
//}
