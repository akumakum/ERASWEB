package com.eras.erasweb.model;



public enum ASASCORE {

    SCORE_2(2),
    SCORE_3(3);

    private final int score;

    ASASCORE(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }
}

//public enum ASASCORE {
//	
//      SCORE_2(2),
//      SCORE_3(3);
//
//      private final int score;
//
//      ASASCORE(int score) {
//          this.score = score;
//      }
//
//      public int getScore() {
//          return score;
//      }
//  }
//
