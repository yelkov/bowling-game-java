package edu.badpals.bowlinggame.scoreCard;

import java.util.Optional;

import static org.junit.Assert.*;

public class ScoreCardTest {
    public void test_getPins(){
        ScoreCard scoreCard = new ScoreCard("12345123451234512345");
        String pins = scoreCard.getPins();
        assertEquals("12345123451234512345",pins);
    }
    public void test_totalScoreHittingPins(){
        ScoreCard scoreCard = new ScoreCard("12345123451234512345");
        Integer totalScore = scoreCard.getTotalScore();
        assertEquals((Integer) 60,totalScore);
    }
    public void test_totalScoreHittingPinsFail(){
        ScoreCard scoreCard = new ScoreCard("9-9-9-9-9-9-9-9-9-9-");
        Integer totalScore = scoreCard.getTotalScore();
        assertEquals((Integer)90,totalScore);
    }

    public void test_getFrames(){
        ScoreCard scoreCard = new ScoreCard("9-9-9-9-9-9-9-9-9-9-");
        String[] frames = {"9-","9-","9-","9-","9-","9-","9-","9-","9-","9-"};
        assertEquals(frames,scoreCard.getFrames());
    }

}