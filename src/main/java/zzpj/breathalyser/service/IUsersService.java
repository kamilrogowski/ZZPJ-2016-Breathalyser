package zzpj.breathalyser.service;

import javafx.beans.property.SimpleStringProperty;
import zzpj.breathalyser.model.User;
import zzpj.breathalyser.repository.IUsersRepository;
import zzpj.breathalyser.repository.UsersRepository;

/**
 * Created by Kamil Rogowski on 28.08.2016.
 */
public interface IUsersService {
    void initializeUsers();
    boolean addUser(User user);
    boolean onLogin(String login, String password);
    void setUsersRepository(UsersRepository usersRepository);
}
