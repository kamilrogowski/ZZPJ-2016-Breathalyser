package zzpj.breathalyser.repository;

import org.junit.Assert;
import org.junit.Test;
import zzpj.breathalyser.model.*;

import static org.junit.Assert.*;

/**
 * Created by Krzychu on 29.08.2016.
 */
public class UsersRepositoryTest {
    @Test
    public void initializeUsers() throws Exception {

        IUsersRepository usersRepository = new UsersRepository();
        usersRepository.initializeUsers();
        int result = usersRepository.getUsers().size();
        int expected = 5;
        Assert.assertEquals(expected, result);

    }

    @Test
    public void addUser() throws Exception {

        UserDetails userDetails = new UserDetails("name", "surname", 100, 180, 25, true);
        User user = new User("login", "password", "email", userDetails);
        IUsersRepository usersRepository = new UsersRepository();
        usersRepository.addUser(user);
        User result = usersRepository.getUsers().get(0);
        User expected = user;
        Assert.assertEquals(expected, result);
    }

    @Test
    public void getUsers() throws Exception {
        UserDetails userDetails = new UserDetails("name", "surname", 100, 180, 25, true);
        User user = new User("login", "password", "email", userDetails);
        IUsersRepository usersRepository = new UsersRepository();
        usersRepository.addUser(user);
        int result = usersRepository.getUsers().size();
        int expected = 1;
        Assert.assertEquals(expected, result);
    }

}