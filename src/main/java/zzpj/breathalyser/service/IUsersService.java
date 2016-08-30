package zzpj.breathalyser.service;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import zzpj.breathalyser.model.User;
import zzpj.breathalyser.repository.IUsersRepository;
import zzpj.breathalyser.repository.UsersRepository;

/**
 * Created by Kamil Rogowski on 28.08.2016.
 */
public interface IUsersService {
    void initializeUsers();
    boolean addUser(User user);
    User onLogin(String login, String password);
    ObservableList<User> getAllUsers();
    void setUsersRepository(UsersRepository usersRepository);
<<<<<<< HEAD

    IUsersRepository getUsersRepository();
=======
    User findByLogin(String login);
>>>>>>> e746242c01b44816723701c46f408e6fe5e77b59
}
