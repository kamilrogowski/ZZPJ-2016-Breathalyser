package zzpj.breathalyser.controller;


import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import zzpj.breathalyser.repository.IUsersRepository;
import zzpj.breathalyser.repository.UsersRepository;
import zzpj.breathalyser.service.IUsersService;
import zzpj.breathalyser.service.UsersService;

public class LoginController {

    private IUsersService usersService;

    @FXML
    private TextField userLogin;
    @FXML
    private TextField  userPassword;

    public LoginController(){
    }
    public void onLogin(){
        final boolean b = usersService.onLogin(userLogin.getText(), userPassword.getText());
        System.out.println(b);
    }

    public void setUsersService(IUsersService usersService) {
        this.usersService = usersService;
    }

}
