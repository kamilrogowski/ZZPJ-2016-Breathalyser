package zzpj.breathalyser.controller;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import zzpj.breathalyser.model.User;

/** A table cell containing a button for adding a new person. */
public class AddPersonCell extends TableCell<User, Boolean> {
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
    AddPersonCell(final TableView table, User currentAccount) {
        paddedButton.setPadding(new Insets(3));
        paddedButton.getChildren().add(addButton);
        addButton.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent mouseEvent) {
                buttonY.set(mouseEvent.getScreenY());
                //currentAccount.getFriends().add((User)table.getSelectionModel().getSelectedItem());
                //System.out.println(currentAccount.getFriends().toString());
            }
        });
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent actionEvent) {
                table.getSelectionModel().setCellSelectionEnabled(true);
                User user = (User) table.getSelectionModel().getSelectedItem();
                    currentAccount.getFriends().add(user);
                    System.out.println("Selected Value" + user);
                System.out.println(currentAccount.getFriends().toString());
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