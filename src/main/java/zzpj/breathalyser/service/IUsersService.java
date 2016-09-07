package zzpj.breathalyser.service;

import javafx.collections.ObservableList;
import zzpj.breathalyser.model.User;

/**
 * Created by Kamil Rogowski on 28.08.2016.
 */
public interface IUsersService {
    void initializeUsers();
    boolean addUser(User user);
    User onLogin(String login, String password);
    ObservableList<User> getAllUsers();
    User findByLogin(String login);
    boolean addUserAvaiableToEvent(User user);
    ObservableList<User> getUsersAvailableToEvent();
    void removeUserAvailableFromEvent(User user);

}
