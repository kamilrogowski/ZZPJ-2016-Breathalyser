package zzpj.breathalyser.model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import lombok.Data;


/**
 * Created by Kamil Rogowski on 13.06.2016.
 */
@Data
public class Score {

    private DoubleProperty scoreValue = new SimpleDoubleProperty();
    private User userScore;

}
