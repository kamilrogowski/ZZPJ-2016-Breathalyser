package zzpj.breathalyser.controller;

import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;
import lombok.Setter;
import lombok.extern.java.Log;
import zzpj.breathalyser.Utils.FieldValidator;
import zzpj.breathalyser.Utils.ValidationMessageSuffix;
import zzpj.breathalyser.model.User;
import zzpj.breathalyser.model.UserDetails;
import zzpj.breathalyser.service.IUsersService;

/**
 * Created by Kamil Rogowski on 28.08.2016.
 */
@Log
public class RegistrationController {

    @Setter
    private IUsersService usersService;
    @FXML
    private TextField loginTyped;
    @FXML
    private TextField passwordTyped;
    @FXML
    private TextField passwordRepeatedTyped;
    @FXML
    private TextField emailTyped;
    @FXML
    private TextField nameTyped;
    @FXML
    private TextField surnameTyped;
    @FXML
    private TextField weightTyped;
    @FXML
    private TextField heightTyped;
    @FXML
    private TextField ageTyped;
    @FXML
    private RadioButton femaleRadioButton;
    @FXML
    private Text message;

    @FXML
    public void onRegister() {

        DoubleStringConverter doubleStringConverter = new DoubleStringConverter();
        IntegerStringConverter integerStringConverter = new IntegerStringConverter();
        User user = new User();
        user.setLogin(loginTyped.getText());
        user.setPassword(passwordTyped.getText());
        user.setEmail(emailTyped.getText());
        user.setName(nameTyped.getText());
        user.setSurname(surnameTyped.getText());
        UserDetails userDetails = new UserDetails();

        if (validateIntDoubleFields()) {
            final Integer age = integerStringConverter.fromString(ageTyped.getText());
            final Double weight = doubleStringConverter.fromString(weightTyped.getText());
            final Double height = doubleStringConverter.fromString(heightTyped.getText());
            userDetails.setWeight(weight);
            userDetails.setHeight(height);
            userDetails.setAge(age);

            userDetails.setGender(femaleRadioButton.isSelected());
            user.setUserDetails(userDetails);

            if (!passwordTyped.equals(passwordRepeatedTyped)) {
                message.setText("PASSWORD MUST MATCH" + ValidationMessageSuffix.GRR);
            } else {
                message.setText("");
                final boolean userExists = usersService.addUser(user);
                if (!userExists) {
                    message.setText("THIS LOGIN ALREADY EXISTS, TRY AGAIN" + ValidationMessageSuffix.EHH);
                } else message.setText("");

            }
        }
        else  message.setText("PLS BE POLITE AND DON'T DESTROY MY PROGRAM" + ValidationMessageSuffix.WRR);

    }

    public boolean validateIntDoubleFields() {

        return FieldValidator.isInt(ageTyped.getText()) &&
                FieldValidator.isDouble(weightTyped.getText()) &&
                FieldValidator.isDouble(heightTyped.getText());


    }
}

