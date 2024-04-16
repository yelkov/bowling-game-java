package edu.badpals.bowlinggame.frames;

public class RegularFrame implements Frame{
    private Character firstPin = ' ';
    private Character secondPin = ' ';
    private int firstPinScore = 0;
    private int secondPinScore = 0;
    private int frameScore = 0;
    private Frame nextFrame;
    private Frame secondNextFrame;

    public RegularFrame(Character firstPin,Character secondPin){
        this.firstPin = firstPin;
        this.secondPin = secondPin;
        calculateFrameScore();
    }
    private void calculateFrameScore() {
        firstPinScore = pinToScore(firstPin);
        secondPinScore = pinToScore(secondPin);
        frameScore = firstPinScore + secondPinScore;
    }
    private int pinToScore(Character pin){
        return pin == '-'? 0 : Character.getNumericValue(pin);
    }
    @Override
    public int getFirstPinScore(){
        return firstPinScore;
    }
    @Override
    public int getSecondPinScore() {
        return secondPinScore;
    }

    @Override
    public void setNextFrame(Frame nextFrame) {
        this.nextFrame=nextFrame;
    }

    @Override
    public void setSecondNextFrame(Frame secondNextFrame) {
        this.secondNextFrame=secondNextFrame;

    }

    @Override
    public int getFrameScore() {
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
