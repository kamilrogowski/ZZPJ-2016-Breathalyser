package zzpj.breathalyser.model;

import javafx.beans.property.StringProperty;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Kamil Rogowski on 13.06.2016.
 */
@Data
 public class User {

    private StringProperty login;
    private StringProperty password;
    private StringProperty email;
    private UserDetails userDetails;
    private Set<Meeting> meetings = new HashSet<>();
    private Set<Score> userScores = new HashSet<>();
    private Set<User> friends = new HashSet<>();

   public final void setLogin(String value) {
      login.set(value);
   }

   public final String getLogin() {
      return login.get();
   }

   public final StringProperty loginProperty() {
      return login;
   }

   public final void setPassword(String value) {
      password.set(value);
   }

   public final String getPassword() {
      return password.get();
   }

   public final StringProperty passwordProperty() {
      return password;
   }

   public final void setEmail(String value) {
      email.set(value);
   }

   public final String getEmail() {
      return email.get();
   }

   public final StringProperty emailProperty() {
      return email;
   }

}
