package zzpj.breathalyser.controller;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.util.Callback;
import lombok.Setter;
import zzpj.breathalyser.model.User;
import zzpj.breathalyser.model.UserDetails;
import zzpj.breathalyser.service.IUsersService;

import java.net.URL;
import java.util.Observable;
import java.util.ResourceBundle;


public class DashboardController implements Initializable{

    @Setter
    private IUsersService usersService;

    @Setter
    private User myAccount;
    /**
     * TODO Field for user login
     */
    @FXML
    private Text loginMessage;

    @FXML private TableView<User> allUsers;
    @FXML private TableColumn<User, String> loginColumn;
    @FXML private TableColumn<UserDetails, String> nameColumn;
    @FXML private TableColumn<UserDetails, String> surnameColumn;
    @FXML private TableColumn<UserDetails, String> phoneColumn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loginColumn.setCellValueFactory(new PropertyValueFactory<>("login"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        surnameColumn.setCellValueFactory(new PropertyValueFactory<>("surname"));
        phoneColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
    }
    public void initUserList(){
     allUsers.setItems(usersService.getAllUsers());

    }
}
