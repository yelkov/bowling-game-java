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
        if (firstPin == '-'){
            frameScore = Character.getNumericValue(secondPin);
        }
        else if(secondPin == '-'){
            frameScore = Character.getNumericValue(firstPin);
        }
        else{
            frameScore = Character.getNumericValue(firstPin) + Character.getNumericValue(secondPin);
        }
    }
    public int getFirstPin(){
        return Character.getNumericValue(firstPin);
    }

    @Override
    public int getFrameScore() {
        return this.frameScore;
    }
    @Override
    public String toString() {
        return firstPin.toString() +
                "|" +
                secondPin.toString();
    }
}
