package edu.badpals.bowlinggame.frames;

import org.junit.Test;

import static org.junit.Assert.*;

public class SpareFrameTest {
    @Test
    public void test_spareFrame(){
        Frame spareFrame = new SpareFrame('5');
        assertEquals(10,spareFrame.getFrameScore());
    }

}