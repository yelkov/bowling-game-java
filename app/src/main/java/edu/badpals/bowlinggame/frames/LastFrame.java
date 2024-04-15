package edu.badpals.bowlinggame.frames;

public class LastFrame implements Frame{
    private Character firstPin = ' ';
    private Character secondPin = ' ';
    private Character thirdPin = ' ';
    private int firstPinScore = 0;
    private int secondPinScore = 0;
    private int thirdPinScore = 0;
    private int frameScore = 0;
    public LastFrame(Character firstPin, Character secondPin){
        this.firstPin = firstPin;
        this.secondPin = secondPin;
        calculateFrame();
    }
    public LastFrame(Character firstPin,Character secondPin,Character thirdPin){
        this.firstPin = firstPin;
        this.secondPin = secondPin;
        this.thirdPin = thirdPin;
        calculateFrame();
    }

    private void calculateFrame(){
        firstPinScore = pinToScore(firstPin);;
        secondPinScore = pinToScore(secondPin);
        thirdPinScore = pinToScore(thirdPin);
        if (secondPin == '/'){secondPinScore = 10 - firstPinScore;}
        if (thirdPin == '/'){thirdPinScore = 10 - secondPinScore;}

        frameScore = firstPinScore + secondPinScore + thirdPinScore;
    }

    private int pinToScore(Character pin) {
        int firstScore;
        switch (pin){
            case '-',' ':
                return  0;
            case 'x','/':
                return  10;
            default:
                return Character.getNumericValue(pin);
        }
    }

    @Override
    public int getFrameScore() {
        return this.frameScore;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(firstPin)
                .append("|")
                .append(secondPin);
        if (thirdPin != ' '){
            sb.append("|")
                    .append(thirdPin);
        }
        return sb.toString();
    }
    @Override
    public int getFirstPinScore(){
        return firstPinScore;
    }
    public int getSecondPinScore(){
        return secondPinScore;
    }
    public int getThirdPinScore() {
        return thirdPinScore;
    }
}
