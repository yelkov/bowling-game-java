package edu.badpals.bowlinggame.frames;

public class StrikeFrame implements Frame{
    Character pin = 'x';
    private int frameScore = 10;
    private Frame nextFrame;
    private Frame secondNextFrame;


    public void calculateFrameScore() {
        if (nextFrame instanceof StrikeFrame){
            frameScore = frameScore + nextFrame.getFirstPinScore() + secondNextFrame.getFirstPinScore();
        }else{
            frameScore = frameScore + nextFrame.getFirstPinScore() + nextFrame.getSecondPinScore();
        }
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

    public void setNextFrame(Frame nextFrame) {
        this.nextFrame = nextFrame;
    }

    public void setSecondNextFrame(Frame secondNextFrame) {
        this.secondNextFrame = secondNextFrame;
    }
}
