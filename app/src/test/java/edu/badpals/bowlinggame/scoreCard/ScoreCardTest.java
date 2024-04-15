package edu.badpals.bowlinggame.scoreCard;

import edu.badpals.bowlinggame.frames.Frame;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

public class ScoreCardTest {
    @Test
    public void test_getPins(){
        ScoreCard scoreCard = new ScoreCard("12345123451234512345");
        String pins = scoreCard.getPins();
        assertEquals("12345123451234512345",pins);
    }
    @Test
    public void test_totalScoreHittingPins(){
        ScoreCard scoreCard = new ScoreCard("12345123451234512345");
        Integer totalScore = scoreCard.getTotalScore();
        assertEquals((Integer) 60,totalScore);
    }
    @Test
    public void test_totalScoreHittingPinsFail(){
        ScoreCard scoreCard = new ScoreCard("9-9-9-9-9-9-9-9-9-9-");
        Integer totalScore = scoreCard.getTotalScore();
        assertEquals((Integer)90,totalScore);
    }
@Test
    public void test_getFrames(){
        ScoreCard scoreCard = new ScoreCard("9-9-9-9-9-9-9-9-9-9-");
        String frame0 = "9 -|";
        assertEquals(frame0,scoreCard.getFrames().get(0).toString());
        ScoreCard strikeScoreCard = new ScoreCard("9-x9-9-x9-9-9-9-9xx");
        String frame10 = "9 x| x|";
        assertEquals(frame10,strikeScoreCard.getFrames().get(9).toString());
        ScoreCard spareScoreCard = new ScoreCard("9-x9-9/x9-9-1/9-9xx");
        String frame4 = "9 /|";
        assertEquals(frame4,spareScoreCard.getFrames().get(3).toString());
    }

}