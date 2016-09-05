package zzpj.breathalyser.service;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import zzpj.breathalyser.model.User;
import zzpj.breathalyser.repository.IUsersRepository;
import zzpj.breathalyser.repository.UsersRepository;

import java.util.List;
import java.util.Set;

/**
 * Created by Kamil Rogowski on 28.08.2016.
 */
public interface IUsersService {
    void initializeUsers();
    boolean addUser(User user);
    User onLogin(String login, String password);
    ObservableList<User> getAllUsers();
    User findByLogin(String login);

}
