package zzpj.breathalyser.model;


import lombok.Data;


/**
 * Created by Kamil Rogowski on 13.06.2016.
 */
@Data
public class AlcoholConsumed {

    private String drinkType;
    private String alcoholLevel;
    private String drinkCapacity;
    private User user;

}
