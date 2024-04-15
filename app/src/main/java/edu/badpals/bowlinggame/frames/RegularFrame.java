package edu.badpals.bowlinggame.frames;

public class RegularFrame implements Frame{
    private Character firstPin = ' ';
    private Character secondPin = ' ';
    private int frameScore = 0;
    public RegularFrame(Character firstPin,Character secondPin){
        this.firstPin = firstPin;
        this.secondPin = secondPin;
    }
    private void calculateFrame() {
        if (firstPin == '-' && secondPin != '-'){
            frameScore = Character.getNumericValue(secondPin);
        }
        else if(firstPin!='-' && secondPin == '-'){
            frameScore = Character.getNumericValue(firstPin);
        }
        else if(firstPin == '-' && secondPin == '-'){
            frameScore = 0;
        }
        else{
            frameScore = Character.getNumericValue(firstPin) + Character.getNumericValue(secondPin);
        }
    }
    @Override
    public int getFirstPinScore(){
        return Character.getNumericValue(firstPin);
    }

    @Override
    public int getFrameScore() {
        calculateFrame();
        return this.frameScore;
    }
    @Override
    public String toString() {
        return firstPin.toString() +
                "|" +
                secondPin.toString();
    }
}
