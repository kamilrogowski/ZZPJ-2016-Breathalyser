package zzpj.breathalyser.tasks;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import lombok.extern.java.Log;
import zzpj.breathalyser.model.User;
import zzpj.breathalyser.service.IUsersService;

@Log
public class AddFriendTask extends TableCell<User, Boolean> {
    final Button addButton = new Button("Add");
    final StackPane paddedButton = new StackPane();
    final DoubleProperty buttonY = new SimpleDoubleProperty();

    public AddFriendTask(final TableView table, User currentAccount, IUsersService usersService, TableView<User> events) {
        paddedButton.setPadding(new Insets(3));
        paddedButton.getChildren().add(addButton);
        addButton.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                buttonY.set(mouseEvent.getScreenY());
            }
        });

        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                table.getSelectionModel().setCellSelectionEnabled(true);
                User user = (User) table.getSelectionModel().getSelectedItem();
                if(user != null && !currentAccount.getFriends().contains(user)){
                    currentAccount.getFriends().add(user);
                    usersService.addUserAvaiableToEvent(user);
                    events.setItems(usersService.getUsersAvailableToEvent());
                    log.info(currentAccount.getFriends().toString());
                }
            }
        });
    }

    @Override
    protected void updateItem(Boolean item, boolean empty) {
        super.updateItem(item, empty);
        if (!empty) {
            setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
            setGraphic(paddedButton);
        } else {
            setGraphic(null);
        }
    }
}