package zzpj.breathalyser.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import zzpj.breathalyser.repository.IUsersRepository;
import zzpj.breathalyser.repository.UsersRepository;
import zzpj.breathalyser.service.IUsersService;
import zzpj.breathalyser.service.UsersService;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Kamil Rogowski on 28.08.2016.
 */

public class ApplicationFacade {

    @FXML private LoginController loginController;

    @FXML private RegistrationController registrationController;

    @FXML private DashboardController dashboardController;
}
