package zzpj.breathalyser.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import zzpj.breathalyser.model.*;

import static org.junit.Assert.*;

/**
 * Created by Krzychu on 28.08.2016.
 */
public class SoberCalculatorTest {
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void getMassOfEthanolInDrinkInGrams() throws Exception {
        Drink beer = new Drink("Beer", 500.0, 5.0); // parametry: nazwa, objętość w ml, ile procent xD
        Drink vodka = new Drink("Vodka", 250, 40.0);
        SoberCalculator calculator = new SoberCalculator();
        calculator.addDrinkToListOfDrink(beer);
        calculator.addDrinkToListOfDrink(beer);
        calculator.addDrinkToListOfDrink(beer);
        calculator.addDrinkToListOfDrink(vodka);
    }

    @Test
    public void setNumberOfStandardDrinksContaining10gramsOfEthanol() throws Exception {

    }

    @Test
    public void getNumberOfStandardDrinksContaining10gramsOfEthanol() throws Exception {

    }

    @Test
    public void getEstimatedPeakBloodAlcoholConcentration() throws Exception {

    }

    @Test
    public void addDrinkToListOfDrink() throws Exception {

    }

}