package edu.badpals.bowlinggame.frames;

public class SpareFrame implements Frame{
    private Character firstPin = ' ';
    private Character secondPin = '/';
    private int firstPinScore = 0;
    private int secondPinScore = 0;
    private int frameScore = 10;
    private Frame nextFrame;
    private Frame secondNextFrame;
    public SpareFrame(Character firstPin,Character secondPin){
        this.firstPin = firstPin;
    }
    @Override
    public int getFirstPinScore(){
        this.firstPinScore = Character.getNumericValue(firstPin);
        return  firstPinScore;
    }
    @Override
    public int getSecondPinScore() {
        return (10 - firstPinScore);
    }

    @Override
    public void setNextFrame(Frame nextFrame) {
        this.nextFrame = nextFrame;
    }

    @Override
    public void setSecondNextFrame(Frame secondNextFrame) {
        this.secondNextFrame = secondNextFrame;
    }

    public void calculateFrameScore() {
        frameScore = frameScore + nextFrame.getFirstPinScore();
    }
    @Override
    public int getFrameScore() {
        if (frameScore == 10){
            calculateFrameScore();
        }
        return this.frameScore;
    }

    @Override
    public String toString() {
        return firstPin.toString() +
                " " +
                 secondPin.toString()+
                "|";
    }
}
