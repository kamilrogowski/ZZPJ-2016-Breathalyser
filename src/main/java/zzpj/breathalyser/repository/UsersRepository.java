package zzpj.breathalyser.repository;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lombok.extern.java.Log;
import zzpj.breathalyser.initialization.UserDataInitializer;
import zzpj.breathalyser.model.User;

/**
 * Created by Kamil Rogowski on 28.08.2016.
 */
@Log
public class UsersRepository implements IUsersRepository {

    private ObservableList<User> users;
    private UserDataInitializer userDataInitializer;
    private ObservableList<User> usersAvailableToEvent;

    public UsersRepository() {
        usersAvailableToEvent = FXCollections.observableArrayList();
        userDataInitializer = new UserDataInitializer();
        users = FXCollections.observableArrayList();
    }

    @Override
    public void initializeUsers() {

        users.addAll(userDataInitializer.initUsers());

        users.forEach((user) -> log.info("User : " + user.getLogin() + " has been created"));

    }

    @Override
    public void addUser(User user) {
        users.add(user);
    }

    public ObservableList<User> getUsers() {
        return users;
    }

    @Override
    public void addUserToEvent(User user) {
        usersAvailableToEvent.add(user);
    }

    @Override
    public ObservableList<User> getUsersToEvent() {
        return usersAvailableToEvent;
    }

    @Override
    public void removeUserFromEvent(User user) {
     usersAvailableToEvent.remove(user);
    }

}
