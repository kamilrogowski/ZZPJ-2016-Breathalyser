/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zzpj.breathalyser.model;

import lombok.Data;

/**
 *
 * @author Krzychu
 */
@Data
public class Drink {

    private String nameOfDrink;
    private double volumeOfDrinkInMl;
    private double percentageOfEthanolInDrink;
    private double volumeOfEthanolInMl;

    public Drink(String nameOfDrink, double volumeOfDrinkInMl, double percentageOfEthanolInDrink) {
        this.nameOfDrink = nameOfDrink;
        this.volumeOfDrinkInMl = volumeOfDrinkInMl;
        this.percentageOfEthanolInDrink = percentageOfEthanolInDrink;
    }

    public double getVolumeOfEthanolInDrinkInMl(){
        return volumeOfEthanolInMl = this.getVolumeOfDrinkInMl()*(this.getPercentageOfEthanolInDrink()/100);
    }
}
