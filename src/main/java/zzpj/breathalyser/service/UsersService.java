package zzpj.breathalyser.service;

import com.sun.istack.internal.NotNull;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import lombok.extern.java.Log;
import zzpj.breathalyser.model.User;
import zzpj.breathalyser.repository.IUsersRepository;
import zzpj.breathalyser.repository.UsersRepository;

import javax.inject.Inject;

/**
 * Created by Kamil Rogowski on 28.08.2016.
 */
@Log
public class UsersService implements IUsersService {

    private IUsersRepository usersRepository;

    public void initializeUsers() {
        usersRepository.initializeUsers();
    }

    public boolean addUser(@NotNull User user) {
        if (!usersRepository.getUsers().contains(user)) {
            usersRepository.addUser(user);
            log.info("User: " + user.getLogin() + " has been created");
            return true;
        }
        return false;
    }

    public void setUsersRepository(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public User findByLogin(String login) {
        for (User userFound : usersRepository.getUsers()) {

            if (userFound.getLogin().equals(login)) {
                return userFound;
            }
        }
        return null;
    }

    @Override
    public User onLogin(String login, String password) {

        for (User userToCheck : usersRepository.getUsers()) {

            if (userToCheck.getLogin().equals(login) &&
                    userToCheck.getPassword().equals(password)) {
                return userToCheck;
            }
        }
        return null;
    }

    @Override
    public ObservableList<User> getAllUsers() {
        return usersRepository.getUsers();
    }
}

