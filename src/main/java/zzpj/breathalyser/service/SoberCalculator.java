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
    private DoubleBinding numberOfStandardDrinksContaining10gramsOfEthanol;
    private final double metabolicConstant = 0.017;
    private DoubleBinding massOfEthanolInGrams;
    private final double densityOfEthanol = 0.8;
    private DoubleProperty volumeOfEthanolInMl;
    private DoubleBinding estimatedPeakBloodAlcoholConcentrationInPermilles;
    private final double factorToConvertTheAmountInGramsToSwedishStandards = 1.2;
    private List<Drink> listOfDrink;

    public SoberCalculator() {
    }
    
    public DoubleBinding getMassOfEthanolInDrinkInGrams(List<Drink> listOfDrink){
        for(int i = 0; i < listOfDrink.size(); i++){
        massOfEthanolInGrams = massOfEthanolInGrams.add(densityOfEthanol*listOfDrink.get(i).getVolumeOfEthanolInDrinkInMl());
        }
        return massOfEthanolInGrams;
    }
    
    public void setNumberOfStandardDrinksContaining10gramsOfEthanol(){
        numberOfStandardDrinksContaining10gramsOfEthanol = (this.getMassOfEthanolInDrinkInGrams(this.listOfDrink)).divide(10.0);
    }
    
    public DoubleBinding getNumberOfStandardDrinksContaining10gramsOfEthanol(){
        this.setNumberOfStandardDrinksContaining10gramsOfEthanol();
        return this.numberOfStandardDrinksContaining10gramsOfEthanol;
    }
    
    public DoubleBinding getEstimatedPeakBloodAlcoholConcentration(UserDetails userDetails, DoubleProperty drinkingPeriodInHours){
        
        estimatedPeakBloodAlcoholConcentrationInPermilles = this.getNumberOfStandardDrinksContaining10gramsOfEthanol().multiply(this.constantForBodyWaterInTheBlood).multiply(this.factorToConvertTheAmountInGramsToSwedishStandards);
        estimatedPeakBloodAlcoholConcentrationInPermilles = estimatedPeakBloodAlcoholConcentrationInPermilles.divide(userDetails.getBodyWaterConstant()*userDetails.getWeight());
        estimatedPeakBloodAlcoholConcentrationInPermilles = estimatedPeakBloodAlcoholConcentrationInPermilles.subtract(drinkingPeriodInHours.multiply(this.metabolicConstant));
        estimatedPeakBloodAlcoholConcentrationInPermilles = estimatedPeakBloodAlcoholConcentrationInPermilles.multiply(10.0);
        return estimatedPeakBloodAlcoholConcentrationInPermilles;
    }
    
    public void addDrinkToListOfDrink(Drink drink){
        this.listOfDrink.add(drink);
    }
    
}

