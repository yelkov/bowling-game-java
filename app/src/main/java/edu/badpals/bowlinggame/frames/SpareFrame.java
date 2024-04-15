package edu.badpals.bowlinggame.frames;

public class SpareFrame implements Frame{
    private Character firstPin = ' ';
    private Character secondPin = '/';
    private int frameScore = 10;
    public SpareFrame(Character firstPin){
        this.firstPin = firstPin;
    }
    @Override
    public int getFirstPinScore(){
        return Character.getNumericValue(firstPin);
    }
    @Override
    public int getSecondPinScore() {
        return 10;
    }

    @Override
    public int getFrameScore() {
        return this.frameScore;
    }
    public int getFirstPin(){
        return Character.getNumericValue(firstPin);
    }

    @Override
    public String toString() {
        return firstPin.toString() +
                "|" +
                 secondPin.toString();
    }
}
