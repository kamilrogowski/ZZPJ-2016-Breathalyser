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

    public Drink(String nameOfDrink, double volumeOfDrinkInMl, double percentageOfEthanolInDrink){
        this.nameOfDrink = nameOfDrink;
        this.volumeOfDrinkInMl = volumeOfDrinkInMl;
        this.percentageOfEthanolInDrink = percentageOfEthanolInDrink;
    }

    private String nameOfDrink;
    private double volumeOfDrinkInMl;
    private double percentageOfEthanolInDrink;

    private double volumeOfEthanolInMl;

    public double getVolumeOfEthanolInDrinkInMl(){
        return volumeOfEthanolInMl = this.getVolumeOfDrinkInMl()*(this.getPercentageOfEthanolInDrink()/100);
    }

    public String getNameOfDrink(){
        return this.nameOfDrink;
    }

    public double getVolumeOfDrinkInMl(){
        return this.volumeOfDrinkInMl;
    }

    public double getPercentageOfEthanolInDrink(){
        return this.percentageOfEthanolInDrink;
    }

    public void setNameOfDrink(String nameOfDrink){
        this.nameOfDrink = nameOfDrink;
    }

    public void setVolumeOfDrinkInMl(double volumeOfDrinkInMl){
        this.volumeOfDrinkInMl = volumeOfDrinkInMl;
    }

    public void setPercentageOfEthanolInDrink(double percentageOfEthanolInDrink){
        this.percentageOfEthanolInDrink = percentageOfEthanolInDrink;
    }
}
