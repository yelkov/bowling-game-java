package edu.badpals.bowlinggame.frames;

public class FrameFactory {
    private Frame frame;
    public static Frame getFrame(Character firstPin){
        return new StrikeFrame();
    }
    public static Frame getFrame(Character firstPin,Character secondPin){
        if (secondPin == '/'){
            return new SpareFrame(firstPin,secondPin);
        }else{
            return new RegularFrame(firstPin,secondPin);
        }
    }
    public static Frame getLastFrame(Character firstPin, Character secondPin){
        return new LastFrame(firstPin,secondPin);
    }
    public static Frame getLastFrame(Character firstPin, Character secondPin, Character thirdPin){
        return new LastFrame(firstPin,secondPin,thirdPin);
    }
}
