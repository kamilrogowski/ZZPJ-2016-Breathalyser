package zzpj.breathalyser.model;

import javafx.beans.property.*;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Kamil Rogowski on 27.08.2016.
 */
@Data
@NoArgsConstructor
public class UserDetails {
    private String name;
    private String surname;
    private double weight;
    private double height;
    private int age;
    private boolean gender;
    private double bodyWaterConstant; // 0.49 - body water constant for FEMALE, 0.58 - body water constant for MALE

    public UserDetails(String name, String surname, double weight, double height, int age, boolean gender) {
        this.name = name;
        this.surname = surname;
        this.weight = weight;
        this.height = height;
        this.age = age;
        this.gender = gender;
        if (gender) bodyWaterConstant = 0.49;
        else bodyWaterConstant = 0.58;
    }

}
