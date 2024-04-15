package edu.badpals.bowlinggame.frames;

public class LastFrame implements Frame{
    private Character firstPin = ' ';
    private Character secondPin = ' ';
    private Character thirdPin = ' ';
    private int frameScore = 0;
    public LastFrame(Character firstPin, Character secondPin){
        this.firstPin = firstPin;
        this.secondPin = secondPin;
    }
    public LastFrame(Character firstPin,Character secondPin,Character thirdPin){
        this.firstPin = firstPin;
        this.secondPin = secondPin;
        this.thirdPin = thirdPin;
    }

    private void calculateFrame(){
        int firstScore = pinToScore(firstPin);;
        int secondScore = pinToScore(secondPin);
        int thirdScore = pinToScore(thirdPin);
        if (secondPin == '/'){secondScore = 10 - firstScore;}
        if (thirdPin == '/'){thirdScore = 10 - secondScore;}

        frameScore = firstScore + secondScore + thirdScore;
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
        calculateFrame();
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
    public int getFirstPinScore(){
        calculateFrame();
        return Character.getNumericValue(firstPin);
    }
}
