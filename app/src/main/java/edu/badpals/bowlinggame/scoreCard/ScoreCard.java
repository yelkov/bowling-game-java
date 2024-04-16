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
    private int totalScore = 0;
    private List<Frame> frames = new ArrayList<>();

    public ScoreCard(String pins) {
        this.pins = pins;
        splitPinsIntoFrames();
        calculateTotalScore();
    }
    public List<Frame> getFrames() {
        return this.frames;
    }

    public String getPins() {
        return this.pins;
    }


    public Integer getTotalScore() {
        return totalScore;
    }

    public void printScoreByFrame(){
        int scoreByFrame = 0;
        StringBuilder sb = new StringBuilder();
        for (Frame frame : getFrames()){
            sb.append(frame.toString())
                    .append("\t");
        }
        sb.append("\n");
        for (Frame frame: getFrames()){
            scoreByFrame += frame.getFrameScore();
            sb.append(Integer.toString(scoreByFrame))
                    .append("\t");
        }
        System.out.println(sb.toString());
    }
    private void calculateTotalScore(){
        int totalScore = 0;
        for (int i = 0; i < getFrames().size();i++){
            if (i < 8){
                frames.get(i).setNextFrame(frames.get(i+1));
                frames.get(i).setSecondNextFrame(frames.get(i+2));
                totalScore += frames.get(i).getFrameScore();
            }if(i==8){
                frames.get(i).setNextFrame(frames.get(i+1));
                totalScore += frames.get(i).getFrameScore();
            }if(i == 9){
                totalScore += frames.get(i).getFrameScore();
            }

            }
        setTotalScore(totalScore);
        }

    private void setTotalScore(int score){
        this.totalScore = score;
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

}

