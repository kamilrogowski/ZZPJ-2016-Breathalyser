package zzpj.breathalyser.repository;

import javafx.collections.ObservableList;
import zzpj.breathalyser.model.Score;

/**
 * Created by Kamil Rogowski on 07.09.2016.
 */
public interface IScoreRepository {
    void addScore(Score user);
    ObservableList<Score> getScores();
    void removeScore(Score user);
}
