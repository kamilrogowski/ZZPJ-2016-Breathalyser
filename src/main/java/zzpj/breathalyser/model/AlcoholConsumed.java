package zzpj.breathalyser.model;


import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import lombok.Data;


/**
 * Created by Kamil Rogowski on 13.06.2016.
 */
@Data
public class AlcoholConsumed {

    private StringProperty drinkType = new SimpleStringProperty();
    private StringProperty alcoholLevel = new SimpleStringProperty();
    private StringProperty drinkCapacity = new SimpleStringProperty();
    private User user;

}
