package zzpj.breathalyser.initialization;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import zzpj.breathalyser.model.User;
import zzpj.breathalyser.model.UserDetails;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kamil Rogowski on 27.08.2016.
 */
public class UserDataInitializer {

    private final int USERS_MAX_SIZE = 5;

    private ObservableList<User> userData = FXCollections.observableArrayList();

    public ObservableList<User> initUsers() {
        for (int i = 0; i < USERS_MAX_SIZE; i++) {
            userData.add(generateUser(i));
        }
        return userData;
    }


    private User generateUser(int i) {
        String login = "login" + i;
        String password = "password" + i;
        String email = "email" + i + "@com.pl";
        final UserDetails userDetails = generateUserDetails(i);

        return new User(login, password, email, userDetails);
    }

    private UserDetails generateUserDetails(int i) {
        String name = "name" + i;
        String surname = "surname" + i;
        String phone = "11122233" + i;
        double weight = 120 + i * 2;
        double height = 50 + i * 2;
        int age = 50 + i * 2;
        boolean gender = i % 2 == 0;

        return new UserDetails(name, surname, phone, weight, height, age, gender);
    }

}
