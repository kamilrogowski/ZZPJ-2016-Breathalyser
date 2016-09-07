/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zzpj.breathalyser.service;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import zzpj.breathalyser.model.Drink;
import zzpj.breathalyser.model.User;
import zzpj.breathalyser.model.UserDetails;

import java.util.ArrayList;
import java.util.List;

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

    public ObservableList<Drink> getListOfDrink() {
        return listOfDrink;
    }

    public void setListOfDrink(ObservableList<Drink> listOfDrink) {
        this.listOfDrink = listOfDrink;
    }

    private ObservableList<Drink> listOfDrink = FXCollections.observableArrayList();;

    public SoberCalculator(){
        numberOfStandardDrinksContaining10gramsOfEthanol = 0.0;
        massOfEthanolInGrams = 0.0;
        estimatedPeakBloodAlcoholConcentrationInPermilles = 0.0;
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
        numberOfStandardDrinksContaining10gramsOfEthanol = 0.0;
        massOfEthanolInGrams = 0.0;
        return estimatedPeakBloodAlcoholConcentrationInPermilles;
    }

    public void addDrinkToListOfDrink(Drink drink){
        this.listOfDrink.add(drink);
    }

}
