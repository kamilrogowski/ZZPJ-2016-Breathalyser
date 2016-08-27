/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zzpj.breathalyser.model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Krzychu
 */
public class Drink {

    public Drink(StringProperty nameOfDrink, DoubleProperty volumeOfDrinkInMl, DoubleProperty percentageOfEthanolInDrink) {
        this.nameOfDrink = nameOfDrink;
        this.volumeOfDrinkInMl = volumeOfDrinkInMl;
        this.percentageOfEthanolInDrink = percentageOfEthanolInDrink;
    }

    public final void setNameOfDrink(String value) {
        nameOfDrink.set(value);
    }

    public final String getNameOfDrink() {
        return nameOfDrink.get();
    }

    public final StringProperty nameOfDrinkProperty() {
        return nameOfDrink;
    }

    public final void setVolumeOfDrinkInMl(Double value) {
        volumeOfDrinkInMl.set(value);
    }

    public final Double getVolumeOfDrinkInMl() {
        return volumeOfDrinkInMl.get();
    }

    public final DoubleProperty volumeOfDrinkInMlProperty() {
        return volumeOfDrinkInMl;
    }

    public final void setPercentageOfEthanolInDrink(Double value) {
        percentageOfEthanolInDrink.set(value);
    }

    public final Double getPercentageOfEthanolInDrink() {
        return percentageOfEthanolInDrink.get();
    }

    public final DoubleProperty percentageOfEthanolInDrinkProperty() {
        return percentageOfEthanolInDrink;
    }
    
    private StringProperty nameOfDrink;
    private DoubleProperty volumeOfDrinkInMl;
    private DoubleProperty percentageOfEthanolInDrink;
    
    private double volumeOfEthanolInMl;
    
    public double getVolumeOfEthanolInDrinkInMl(){
        return volumeOfEthanolInMl = this.getVolumeOfDrinkInMl()*(this.getPercentageOfEthanolInDrink()/100);
    }
    

}
