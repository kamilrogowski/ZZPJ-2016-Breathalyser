package zzpj.breathalyser.repository;

import javafx.collections.ObservableList;
import zzpj.breathalyser.model.User;

/**
 * Created by Kamil Rogowski on 28.08.2016.
 */
public interface IUsersRepository {

     void initializeUsers();
     void addUser(User user);
     ObservableList<User> getUsers();
     void addUserToEvent(User user);
     ObservableList<User> getUsersToEvent();
     void removeUserFromEvent(User user);
}
