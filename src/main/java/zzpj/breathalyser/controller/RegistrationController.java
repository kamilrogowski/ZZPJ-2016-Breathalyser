package zzpj.breathalyser.controller;

import com.sun.istack.internal.NotNull;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;
import lombok.Setter;
import lombok.extern.java.Log;
import zzpj.breathalyser.Utils.ValidationMessageSuffix;
import zzpj.breathalyser.model.User;
import zzpj.breathalyser.model.UserDetails;
import zzpj.breathalyser.repository.IUsersRepository;
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

        final @NotNull Integer age = integerStringConverter.fromString(ageTyped.getText());
        final @NotNull Double weight = doubleStringConverter.fromString(weightTyped.getText());
        final @NotNull Double height = doubleStringConverter.fromString(heightTyped.getText());

        UserDetails userDetails = new UserDetails();
        userDetails.setName(nameTyped.getText());
        userDetails.setSurname(surnameTyped.getText());
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
                message.setText("THIS LOGIN ALREADY EXITS, TRY AGAIN"  + ValidationMessageSuffix.EHH);
            } else message.setText("");
        }

    }
}

