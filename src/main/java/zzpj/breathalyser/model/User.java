package zzpj.breathalyser.model;

import javafx.beans.property.StringProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
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
    private Set<User> friends = new HashSet<>();

    public Set<User> getFriends() {
        return this.friends;
    }

}
