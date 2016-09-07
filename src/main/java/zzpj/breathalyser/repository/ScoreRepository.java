package zzpj.breathalyser.repository;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import zzpj.breathalyser.model.Meeting;
import zzpj.breathalyser.model.Score;

/**
 * Created by Kamil Rogowski on 07.09.2016.
 */
public class ScoreRepository implements IScoreRepository{

    private ObservableList<Score> myScores = FXCollections.observableArrayList();
    @Override
    public void addScore(Score score) {
        myScores.add(score);
    }

    @Override
    public ObservableList<Score> getScores() {
        return myScores;
    }

    @Override
    public void removeScore(Score score) {
        myScores.remove(score);
    }
}
