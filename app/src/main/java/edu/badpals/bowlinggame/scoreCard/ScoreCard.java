package edu.badpals.bowlinggame.scoreCard;

import edu.badpals.bowlinggame.frames.Frame;

import java.util.Arrays;

public class ScoreCard {
    private String pins = "";
    private Frame[] frames = new Frame[10];

    public ScoreCard(String pins) {
        this.pins = pins;

    }


    public String getPins() {
        return this.pins;
    }

    private void setFrames() {
    }

    public Integer getTotalScore() {
        int totalScore = getPins()
                .chars()
                .map(a -> a == '-' ? '0' : a)
                .map(a -> Character.getNumericValue(a))
                .reduce(0, (total, nextPin) -> total + nextPin);
        return totalScore;

    }

    public Frame[] getFrames() {
        return this.frames;
    }
}

