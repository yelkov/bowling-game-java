package edu.badpals.bowlinggame.scoreCard;

import java.util.Arrays;

public class ScoreCard {
    private String pins = "";

    public ScoreCard(String pins) {
        this.pins = pins;
    }
    public String getPins() {
        return this.pins;
    }

    public Integer getTotalScore() {
       int totalScore = this.pins
               .chars()
               .map(a -> a == '-' ? '0' : a)
               .map(a -> Character.getNumericValue(a))
               .reduce(0,(total,nextPin)-> total + nextPin);
       return totalScore;

    }
}
