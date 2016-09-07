package zzpj.breathalyser.service;

import org.junit.Assert;
import org.junit.Test;
import zzpj.breathalyser.model.Score;

import static org.junit.Assert.*;

/**
 * Created by Krzychu on 07.09.2016.
 */
public class ScoreServiceTest {
    @Test
    public void addScore() throws Exception {
        ScoreService scoreService = new ScoreService();
        Score score = new Score();
        scoreService.addScore(score);
        int actual = scoreService.getScores().size();
        int expected = 1;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getScores() throws Exception {
        ScoreService scoreService = new ScoreService();
        Score score = new Score();
        scoreService.addScore(score);
        int actual = scoreService.getScores().size();
        int expected = 1;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void removeScore() throws Exception {
        ScoreService scoreService = new ScoreService();
        Score score = new Score();
        scoreService.addScore(score);
        scoreService.removeScore(score);
        int actual = scoreService.getScores().size();
        int expected = 0;
        Assert.assertEquals(expected, actual);
    }

}