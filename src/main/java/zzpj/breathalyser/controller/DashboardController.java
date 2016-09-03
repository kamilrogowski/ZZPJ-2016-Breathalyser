package zzpj.breathalyser.controller;


import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.application.Application;
import javafx.beans.property.*;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.*;
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
    @FXML private TableColumn<User, Boolean> actionColumn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loginColumn.setCellValueFactory(new PropertyValueFactory<>("login"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        surnameColumn.setCellValueFactory(new PropertyValueFactory<>("surname"));
        phoneColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        // define a simple boolean cell value for the action column so that the column will only be shown for non-empty rows.
        actionColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<User, Boolean>, ObservableValue<Boolean>>() {
            @Override public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<User, Boolean> features) {
                return new SimpleBooleanProperty(features.getValue() != null);
            }
        });
        // create a cell value factory with an add button for each row in the table.
        actionColumn.setCellFactory(new Callback<TableColumn<User, Boolean>, TableCell<User, Boolean>>() {
            @Override public TableCell<User, Boolean> call(TableColumn<User, Boolean> personBooleanTableColumn) {
                return new AddPersonCell(allUsers);
            }
        });
    }
    public void initUserList(){
     allUsers.setItems(usersService.getAllUsers());

    }

    /** A table cell containing a button for adding a new person. */
    private class AddPersonCell extends TableCell<User, Boolean> {
        // a button for adding a new person.
        final Button addButton       = new Button("Add");
        // pads and centers the add button in the cell.
        final StackPane paddedButton = new StackPane();
        // records the y pos of the last button press so that the add person dialog can be shown next to the cell.
        final DoubleProperty buttonY = new SimpleDoubleProperty();

        /**
         * AddPersonCell constructor
         * @param table the table to which a new person can be added.
         */
        AddPersonCell(final TableView table) {
            paddedButton.setPadding(new Insets(3));
            paddedButton.getChildren().add(addButton);
            addButton.setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override public void handle(MouseEvent mouseEvent) {
                    buttonY.set(mouseEvent.getScreenY());
                    myAccount.getFriends().add((User)table.getSelectionModel().getSelectedItem());
                    //System.out.println(myAccount.getFriends().toString());
                }
            });
            addButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override public void handle(ActionEvent actionEvent) {
                }
            });
        }

        /** places an add button in the row only if the row is not empty. */
        @Override protected void updateItem(Boolean item, boolean empty) {
            super.updateItem(item, empty);
            if (!empty) {
                setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
                setGraphic(paddedButton);
            } else {
                setGraphic(null);
            }
        }
    }

    /**
     * shows a dialog which displays a UI for adding a person to a table.
     * @param parent a parent stage to which this dialog will be modal and placed next to.
     * @param table the table to which a person is to be added.
     * @param y the y position of the top left corner of the dialog.
     */
    private void addFriend(Stage parent, final TableView<User> table, double y) {

        //table.getSelectionModel().select(getTableRow().getIndex());
    }
}
