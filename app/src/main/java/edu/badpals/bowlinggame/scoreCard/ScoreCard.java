package edu.badpals.bowlinggame.scoreCard;

import edu.badpals.bowlinggame.frames.Frame;
import edu.badpals.bowlinggame.frames.FrameFactory;
import edu.badpals.bowlinggame.frames.StrikeFrame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class ScoreCard {
    private String pins = "";
    private List<Frame> frames = new ArrayList<>();

    public ScoreCard(String pins) {
        this.pins = pins;
        splitPinsIntoFrames();
    }


    public String getPins() {
        return this.pins;
    }


    public Integer getTotalScore() {
        int totalScore = getPins()
                .chars()
                .map(a -> a == '-' ? '0' : a)
                .map(a -> Character.getNumericValue(a))
                .reduce(0, (total, nextPin) -> total + nextPin);
        return totalScore;

    }
    private void splitPinsIntoFrames() {
        char[] splitPins = getPins().toCharArray();
        int roll = 0;

        while (frames.size() < 10) {
            if (isLastFrame()) {
                roll = processLastFrame(splitPins, roll);
            } else {
                roll = processRegularFrame(splitPins, roll);
            }
        }
    }

    private boolean isLastFrame() {
        return frames.size() == 9;
    }

    private int processRegularFrame(char[] splitPins, int roll) {
        if (splitPins[roll] != 'x') {
            frames.add(FrameFactory.getFrame(splitPins[roll], splitPins[roll + 1]));
            roll += 2;
        } else {
            frames.add(FrameFactory.getFrame(splitPins[roll]));
            roll++;
        }
        return roll;
    }

    private int processLastFrame(char[] splitPins, int roll) {
        if (roll < splitPins.length - 2) {
            frames.add(FrameFactory.getLastFrame(splitPins[roll], splitPins[roll + 1], splitPins[roll + 2]));
            roll += 3;
        } else if (roll < splitPins.length - 1) {
            frames.add(FrameFactory.getLastFrame(splitPins[roll], splitPins[roll + 1]));
            roll += 2;
        }
        return roll;
    }

    public List<Frame> getFrames() {
        return this.frames;
    }
}

