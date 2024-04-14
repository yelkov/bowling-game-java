package edu.badpals.bowlinggame.frames;

import static org.junit.Assert.*;

public class RegularFrameTest {
    public void test_regularFrame(){
        Frame frame = new RegularFrame('1','1');
        assertEquals(2,frame.getFrameScore());
        Frame newFrame = new RegularFrame('-','-');
        assertEquals(0,newFrame.getFrameScore());
        Frame thirdFrame = new RegularFrame('-','9');
        assertEquals(9,thirdFrame.getFrameScore());
        Frame fourthFrame = new RegularFrame('9','-');
        assertEquals(2,fourthFrame.getFrameScore());
    }

}