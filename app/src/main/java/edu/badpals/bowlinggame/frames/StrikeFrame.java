package edu.badpals.bowlinggame.frames;

public class StrikeFrame implements Frame{
    Character pin = 'x';
    private int frameScore = 10;

    @Override
    public int getFrameScore() {
        return this.frameScore;
    }

    @Override
    public String toString() {
        return this.pin.toString()+
                "|";
    }
    @Override
    public int getFirstPinScore(){
        return frameScore;
    }
    @Override
    public int getSecondPinScore() {
        return 0;
    }
}
