package edu.badpals.bowlinggame.frames;

public interface Frame {
    int getFrameScore();
    int getFirstPinScore();
    int getSecondPinScore();
    void setNextFrame(Frame nextFrame);
    void setSecondNextFrame(Frame secondNextFrame);
}
