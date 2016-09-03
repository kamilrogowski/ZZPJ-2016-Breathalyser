package zzpj.breathalyser.service;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import zzpj.breathalyser.model.*;

import static org.junit.Assert.*;

/**
 * Created by Krzychu on 28.08.2016.
 */
public class SoberCalculatorTest {
   /* @Before
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
        double result = calculator.getMassOfEthanolInDrinkInGrams(calculator.getListOfDrink());
        double expected = 140.0;
        Assert.assertEquals(expected, result, 0.1);
    }

    @Test
    public void getNumberOfStandardDrinksContaining10gramsOfEthanol() throws Exception {
        Drink beer = new Drink("Beer", 500.0, 5.0); // parametry: nazwa, objętość w ml, ile procent xD
        Drink vodka = new Drink("Vodka", 250, 40.0);
        SoberCalculator calculator = new SoberCalculator();
        calculator.addDrinkToListOfDrink(beer);
        calculator.addDrinkToListOfDrink(beer);
        calculator.addDrinkToListOfDrink(beer);
        calculator.addDrinkToListOfDrink(vodka);
        double result = calculator.getNumberOfStandardDrinksContaining10gramsOfEthanol();
        double expected = 14.0;
        Assert.assertEquals(expected, result, 0.0);
    }

    @Test
    public void getEstimatedPeakBloodAlcoholConcentration() throws Exception {

        UserDetails userDetails = new UserDetails("firstName", "surname", 100.0, 181.0, 22, false); // parametry: imię, nazwisko, waga, wzrost, wiek, płeć
        Drink beer = new Drink("Beer", 500.0, 5.0); // parametry: nazwa, objętość w ml, ile procent xD
        Drink vodka = new Drink("Vodka", 250, 40.0);
        SoberCalculator calculator = new SoberCalculator();
        calculator.addDrinkToListOfDrink(beer);
        calculator.addDrinkToListOfDrink(beer);
        calculator.addDrinkToListOfDrink(beer);
        calculator.addDrinkToListOfDrink(vodka);
        double result = calculator.getEstimatedPeakBloodAlcoholConcentration(userDetails, 1.5); // estymowana maksymalna ilość promili we krwi, parametry: osoba, czas picia w godzinach
        double expected = 2.1;
        Assert.assertEquals(expected, result, 0.1);
    }

    @Test
    public void addDrinkToListOfDrink() throws Exception {
        Drink beer = new Drink("Beer", 500.0, 5.0); // parametry: nazwa, objętość w ml, ile procent xD
        Drink vodka = new Drink("Vodka", 250, 40.0);
        SoberCalculator calculator = new SoberCalculator();
        calculator.addDrinkToListOfDrink(beer);
        calculator.addDrinkToListOfDrink(beer);
        calculator.addDrinkToListOfDrink(beer);
        calculator.addDrinkToListOfDrink(vodka);
        int result = calculator.getListOfDrink().size();
        int expected = 4;
        Assert.assertEquals(expected, result, 0.0);
    }*/

}