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
        int firstScore;
        int secondScore;
        int thirdScore;

        switch (firstPin){
            case '-':
                firstScore = 0;
                break;
            case 'x':
                firstScore = 10;
                break;
            default:
                firstScore = Character.getNumericValue(firstPin);
                break;
        }
        switch (secondPin){
            case '-':
                secondScore = 0;
                break;
            case '/':
                secondScore = 10;
                firstScore = 0;
                break;
            case 'x':
                secondScore = 10;
                break;
            default:
                secondScore = Character.getNumericValue(secondPin);
                break;
        }
        switch (thirdPin){
            case ' ', '-':
                thirdScore = 0;
                break;
            case '/':
                secondScore = 0;
                thirdScore = 10;
                break;
            case 'x':
                thirdScore = 10;
                break;
            default:
                thirdScore = Character.getNumericValue(thirdPin);
                break;
        }
        frameScore = firstScore + secondScore + thirdScore;
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
