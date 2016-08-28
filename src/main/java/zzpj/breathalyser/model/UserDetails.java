package zzpj.breathalyser.model;

import javafx.beans.property.*;
import lombok.Data;

/**
 * Created by Kamil Rogowski on 27.08.2016.
 */
@Data
public class UserDetails {
    private String name;
    private String surname;
    private String phoneNumber;
    private double weight;
    private double height;
    private int age;
    private boolean gender;
    private double bodyWaterConstant; // 0.49 - body water constant for FEMALE, 0.58 - body water constant for MALE

    public UserDetails(String name, String surname, String phoneNumber, double weight, double height, int age, boolean gender) {
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.weight = weight;
        this.height = height;
        this.age = age;
        this.gender = gender;
        if (gender) bodyWaterConstant = 0.49;
        else bodyWaterConstant = 0.58;
    }

}
