package zzpj.breathalyser.service;

import javafx.collections.ObservableList;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.java.Log;
import zzpj.breathalyser.model.User;
import zzpj.breathalyser.repository.IUsersRepository;
import zzpj.breathalyser.repository.UsersRepository;

/**
 * Created by Kamil Rogowski on 28.08.2016.
 */
@Log
public class UsersService implements IUsersService {

    @Getter @Setter
    private IUsersRepository usersRepository = new UsersRepository();

    public void initializeUsers() {
        usersRepository.initializeUsers();
    }

    public boolean addUser(User user) {
        if (!usersRepository.getUsers().contains(user)) {
            usersRepository.addUser(user);
            log.info("User: " + user.getLogin() + " has been created");
            return true;
        }
        return false;
    }

    @Override
    public User findByLogin(String login){
        for (User userFound : usersRepository.getUsers()) {

            if (userFound.getLogin().equals(login)) {
                return userFound;
            }
        }
        return null;
    }

    @Override
    public boolean addUserAvaiableToEvent(User user) {
        if (!usersRepository.getUsersToEvent().contains(user)) {
            usersRepository.addUserToEvent(user);
            log.info("User: " + user.getLogin() + " has been added to event");
            return true;
        }
        return false;
    }

    @Override
    public ObservableList<User> getUsersAvailableToEvent() {
        return usersRepository.getUsersToEvent();
    }

    @Override
    public void removeUserAvailableFromEvent(User user) {
         usersRepository.removeUserFromEvent(user);
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

