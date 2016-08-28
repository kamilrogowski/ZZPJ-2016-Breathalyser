package zzpj.breathalyser.repository;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lombok.extern.apachecommons.CommonsLog;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;
import zzpj.breathalyser.initialization.UserDataInitializer;
import zzpj.breathalyser.model.User;

/**
 * Created by Kamil Rogowski on 28.08.2016.
 */
@Log
public class UsersRepository implements IUsersRepository {

    private ObservableList<User> users;
    private UserDataInitializer userDataInitializer;

    public UsersRepository() {

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

}
