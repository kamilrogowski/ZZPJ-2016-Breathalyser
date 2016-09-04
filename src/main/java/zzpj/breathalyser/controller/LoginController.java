package zzpj.breathalyser.controller;


import javafx.beans.property.SimpleStringProperty;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import zzpj.breathalyser.Utils.ValidationMessageSuffix;
import zzpj.breathalyser.model.User;
import zzpj.breathalyser.repository.UsersRepository;
import zzpj.breathalyser.service.IUsersService;
import zzpj.breathalyser.service.UsersService;

import java.io.IOException;

public class LoginController {

    private IUsersService usersService;
    @FXML
    private TextField userLogin;
    @FXML
    private TextField userPassword;
    @FXML
    private Text message;

    public LoginController() {
        UsersRepository usersRepository = new UsersRepository();
        usersService = new UsersService();
        usersService.setUsersRepository(usersRepository);
        usersService.initializeUsers();

    }

    public void onLogin() throws IOException {
        final User myAccount = usersService.onLogin(userLogin.getText(), userPassword.getText());
        if (myAccount != null) {
            message.setText("");
            loadDashboard(myAccount);
        } else {
            message.setText("USER DOESNT EXIST " + ValidationMessageSuffix.WRR + " !!! :(");
        }
    }

    public void onLoadRegister() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("register.fxml"));
        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setScene(new Scene(loader.load()));
        RegistrationController controller = loader.<RegistrationController>getController();
        controller.setUsersService(usersService);
        stage.show();
    }

    public void loadDashboard(User user) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource(
                "dashboard.fxml"));
        Parent root = (Parent) loader.load();
        DashboardController dashboardController = loader.getController();
        dashboardController.setMyAccount(user);
        dashboardController.setUsersService(usersService);
        dashboardController.initUserList();
        Scene newScene = new Scene(root);
        Stage newStage = new Stage();
        newStage.setMaximized(true);
        newStage.setScene(newScene);
        newStage.show();


    }
}
