package edu.badpals.bowlinggame.frames;

import org.junit.Test;

import static org.junit.Assert.*;

public class FrameFactoryTest {
    @Test
    public void test_factory(){
        Frame regular = FrameFactory.getFrame('1','-');
        assertTrue(regular instanceof RegularFrame);
        Frame spare = FrameFactory.getFrame('2','/');
        assertTrue(spare instanceof  SpareFrame);
        Frame strike = FrameFactory.getFrame('x');
        assertTrue(strike instanceof StrikeFrame);
        Frame last = FrameFactory.getLastFrame('1','/','x');
        assertTrue(last instanceof LastFrame);
    }

}