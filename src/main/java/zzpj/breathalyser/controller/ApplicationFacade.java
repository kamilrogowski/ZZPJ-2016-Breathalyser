package zzpj.breathalyser.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import zzpj.breathalyser.repository.IUsersRepository;
import zzpj.breathalyser.repository.UsersRepository;
import zzpj.breathalyser.service.IUsersService;
import zzpj.breathalyser.service.UsersService;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Kamil Rogowski on 28.08.2016.
 */

public class ApplicationFacade implements Initializable {

    private IUsersService usersService;

    public ApplicationFacade() {
    }

    @FXML

    private LoginController loginController;


    @FXML
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        UsersRepository usersRepository = new UsersRepository();
        usersService = new UsersService();
        usersService.setUsersRepository(usersRepository);
        usersService.initializeUsers();
        //loginController.setUsersService(usersService);
    }
}
