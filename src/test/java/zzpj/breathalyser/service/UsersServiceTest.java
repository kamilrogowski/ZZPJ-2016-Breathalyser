package zzpj.breathalyser.service;

import org.junit.Assert;
import org.junit.Test;
import zzpj.breathalyser.model.User;
import zzpj.breathalyser.model.UserDetails;
import zzpj.breathalyser.repository.IUsersRepository;
import zzpj.breathalyser.repository.UsersRepository;

import static org.junit.Assert.*;

/**
 * Created by Krzychu on 29.08.2016.
 */
public class UsersServiceTest {
    @Test
    public void initializeUsers() throws Exception {

        IUsersService usersService = new UsersService();
        usersService.initializeUsers();
        int result = usersService.getAllUsers().size();
        int expected = 5;
        Assert.assertEquals(expected, result);

    }

    @Test
    public void addUser() throws Exception {
        IUsersService usersService = new UsersService();
        UserDetails userDetails = new UserDetails("name", "surname", 100, 180, 25, true);
        User user = new User("login", "password", "email", userDetails);
        usersService.addUser(user);
        User result = usersService.getAllUsers().get(0);
        User expected = user;
        Assert.assertEquals(expected, result);
    }

    @Test
    public void setUsersRepository() throws Exception {

        IUsersService usersService = new UsersService();
        UsersRepository usersRepository = new UsersRepository();
        usersService.setUsersRepository(usersRepository);
        IUsersRepository result = usersService.getUsersRepository();
        IUsersRepository expected = usersRepository;
        Assert.assertEquals(expected, result);

    }

    @Test
    public void onLogin() throws Exception {

        IUsersService usersService = new UsersService();
        UserDetails userDetails = new UserDetails("name", "surname", 100, 180, 25, true);
        User user = new User("login", "password", "email", userDetails);
        usersService.addUser(user);
        boolean result = usersService.onLogin("login", "password");
        boolean expected = true;
        Assert.assertEquals(expected, result);
    }

    @Test
    public void getAllUsers() throws Exception {

        IUsersService usersService = new UsersService();
        UserDetails userDetails = new UserDetails("name", "surname", 100, 180, 25, true);
        User user = new User("login", "password", "email", userDetails);
        usersService.addUser(user);
        int result = usersService.getAllUsers().size();
        int expected = 1;
        Assert.assertEquals(expected, result);

    }

}