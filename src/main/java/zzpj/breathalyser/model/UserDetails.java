package zzpj.breathalyser.model;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;
import lombok.Data;

/**
 * Created by Kamil Rogowski on 27.08.2016.
 */
@Data
public class UserDetails {

    private StringProperty name;
    private StringProperty surname;
    private StringProperty phoneNumber;
    private IntegerProperty weight;
    private IntegerProperty height;
    private IntegerProperty age;
    private BooleanProperty gender;

    public final void setName(String value) {
        name.set(value);
    }

    public final String getName() {
        return name.get();
    }

    public final StringProperty nameProperty() {
        return name;
    }

    public final void setSurname(String value) {
        surname.set(value);
    }

    public final String getSurname() {
        return surname.get();
    }

    public final StringProperty surnameProperty() {
        return surname;
    }

    public final void setPhoneNumber(String value) {
        phoneNumber.set(value);
    }

    public final String getPhoneNumber() {
        return phoneNumber.get();
    }

    public final StringProperty phoneNumberProperty() {
        return phoneNumber;
    }

    public final void setWeight(Integer value) {
        weight.set(value);
    }

    public final Integer getWeight() {
        return weight.get();
    }

    public final IntegerProperty weightProperty() {
        return weight;
    }

    public final void setHeight(Integer value) {
        height.set(value);
    }

    public final Integer getHeight() {
        return height.get();
    }

    public final IntegerProperty heightProperty() {
        return height;
    }

    public final void setAge(Integer value) {
        age.set(value);
    }

    public final Integer getAge() {
        return age.get();
    }

    public final IntegerProperty ageProperty() {
        return age;
    }

    public final void setGender(Boolean value) {
        gender.set(value);
    }

    public final Boolean getGender() {
        return gender.get();
    }

    public final BooleanProperty genderProperty() {
        return gender;
    }


}
