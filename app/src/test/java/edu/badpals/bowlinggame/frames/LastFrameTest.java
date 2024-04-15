package edu.badpals.bowlinggame.frames;

import org.junit.Test;

import static org.junit.Assert.*;

public class LastFrameTest {
    @Test
    public void test_LastFrame(){
        Frame reg = new LastFrame('-','1');
        Frame spare = new LastFrame('-','/','1');
        Frame otroSpare = new LastFrame('5','/','1');
        Frame oneStrike = new LastFrame('x','-','1');
        Frame twoStrike = new LastFrame('x','x','1');
        Frame strikeSpare = new LastFrame('x','-','/');
        Frame threeStrike = new LastFrame('x','x','x');
        assertEquals(1,reg.getFrameScore());
        assertEquals(11,spare.getFrameScore());
        assertEquals(11,otroSpare.getFrameScore());
        assertEquals(11,oneStrike.getFrameScore());
        assertEquals(21,twoStrike.getFrameScore());
        assertEquals(20,strikeSpare.getFrameScore());
        assertEquals(30,threeStrike.getFrameScore());
    }

}