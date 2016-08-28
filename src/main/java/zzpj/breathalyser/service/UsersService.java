package zzpj.breathalyser.service;

import javafx.beans.property.SimpleStringProperty;
import zzpj.breathalyser.model.User;
import zzpj.breathalyser.repository.IUsersRepository;
import zzpj.breathalyser.repository.UsersRepository;

import javax.inject.Inject;

/**
 * Created by Kamil Rogowski on 28.08.2016.
 */
public class UsersService implements IUsersService {

    private IUsersRepository usersRepository;

    public void initializeUsers() {
        usersRepository.initializeUsers();
    }

    public boolean addUser(User user) {
        usersRepository.addUser(user);
        return true;
    }

    public void setUsersRepository(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public boolean onLogin(String login, String password) {

        for (User userToCheck : usersRepository.getUsers()) {

            if (userToCheck != null && userToCheck.getLogin().equals(login) &&
                    userToCheck.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}

