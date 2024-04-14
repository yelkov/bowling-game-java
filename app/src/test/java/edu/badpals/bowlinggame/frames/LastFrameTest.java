package edu.badpals.bowlinggame.frames;

import static org.junit.Assert.*;

public class LastFrameTest {
    public void test_LastFrame(){
        Frame reg = new LastFrame('-','1');
        Frame spare = new LastFrame('-','/','1');
        Frame otroSpare = new LastFrame('5','/','1');
        Frame oneStrike = new LastFrame('x','-','1');
        Frame twoStrike = new LastFrame('x','x','1');
        Frame strikeSpare = new LastFrame('x','-','/');
        Frame threeStrike = new LastFrame('x','x','x');
        assertEquals(1,reg);
        assertEquals(11,spare);
        assertEquals(11,otroSpare);
        assertEquals(11,oneStrike);
        assertEquals(21,twoStrike);
        assertEquals(20,strikeSpare);
        assertEquals(30,threeStrike);
    }

}