/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zzpj.breathalyser.service;

import java.util.*;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.property.DoubleProperty;
import zzpj.breathalyser.model.Drink;
import zzpj.breathalyser.model.UserDetails;

/**
 *
 * @author Krzychu
 */
public class SoberCalculator {

    private final double constantForBodyWaterInTheBlood = 0.806;
    private double numberOfStandardDrinksContaining10gramsOfEthanol;
    private final double metabolicConstant = 0.017;
    private double massOfEthanolInGrams;
    private final double densityOfEthanol = 0.8;
    private double volumeOfEthanolInMl;
    private double estimatedPeakBloodAlcoholConcentrationInPermilles;
    private final double factorToConvertTheAmountInGramsToSwedishStandards = 1.2;

    public List<Drink> getListOfDrink() {
        return listOfDrink;
    }

    public void setListOfDrink(List<Drink> listOfDrink) {
        this.listOfDrink = listOfDrink;
    }

    private List<Drink> listOfDrink;

    public SoberCalculator(){
        numberOfStandardDrinksContaining10gramsOfEthanol = 0.0;
        massOfEthanolInGrams = 0.0;
        estimatedPeakBloodAlcoholConcentrationInPermilles = 0.0;
        listOfDrink = new ArrayList();
    }

    public double getMassOfEthanolInDrinkInGrams(List<Drink> listOfDrink){
        for(int i = 0; i < listOfDrink.size(); i++){
            massOfEthanolInGrams = massOfEthanolInGrams + densityOfEthanol*listOfDrink.get(i).getVolumeOfEthanolInDrinkInMl();
        }
        return massOfEthanolInGrams;
    }

    private void setNumberOfStandardDrinksContaining10gramsOfEthanol(){
        numberOfStandardDrinksContaining10gramsOfEthanol = (this.getMassOfEthanolInDrinkInGrams(this.listOfDrink))/10.0;
    }

    public double getNumberOfStandardDrinksContaining10gramsOfEthanol(){
        this.setNumberOfStandardDrinksContaining10gramsOfEthanol();
        return this.numberOfStandardDrinksContaining10gramsOfEthanol;
    }

    public double getEstimatedPeakBloodAlcoholConcentration(UserDetails userDetails, double drinkingPeriodInHours){

        estimatedPeakBloodAlcoholConcentrationInPermilles = ((this.constantForBodyWaterInTheBlood*this.getNumberOfStandardDrinksContaining10gramsOfEthanol()*this.factorToConvertTheAmountInGramsToSwedishStandards)
                /(userDetails.getBodyWaterConstant()*userDetails.getWeight())
                -(this.metabolicConstant*drinkingPeriodInHours))*10;
        return estimatedPeakBloodAlcoholConcentrationInPermilles;
    }

    public void addDrinkToListOfDrink(Drink drink){
        this.listOfDrink.add(drink);
    }

}
