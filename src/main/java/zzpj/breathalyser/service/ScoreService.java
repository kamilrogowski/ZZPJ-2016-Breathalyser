package zzpj.breathalyser.service;

import javafx.collections.ObservableList;
import zzpj.breathalyser.model.Score;
import zzpj.breathalyser.repository.IScoreRepository;
import zzpj.breathalyser.repository.ScoreRepository;

/**
 * Created by Kamil Rogowski on 07.09.2016.
 */
public class ScoreService implements IScoreService {

    private IScoreRepository scoreRepository = new ScoreRepository();

    @Override
    public void addScore(Score score) {
        scoreRepository.addScore(score);
    }

    @Override
    public ObservableList<Score> getScores() {
        return scoreRepository.getScores();
    }

    @Override
    public void removeScore(Score score) {
        scoreRepository.removeScore(score);
    }
}
