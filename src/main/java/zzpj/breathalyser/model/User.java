package zzpj.breathalyser.model;

import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Kamil Rogowski on 13.06.2016.
 */
@Data
@NoArgsConstructor
 public class User {

    public User(String login, String password, String email, String name, String surname, UserDetails userDetails) {
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
        this.email = email;
        this.userDetails = userDetails;
    }

    private String login;
    private String password;
    private String email;
    private String name;
    private String surname;
    private UserDetails userDetails;
    private Set<Meeting> meetings = new HashSet<>();
    private Set<Score> userScores = new HashSet<>();
    private ObservableList<User> friends = FXCollections.observableArrayList();

   //FIXME temporary "converter'
    @Override
    public String toString() {
        return name;

    }
}
