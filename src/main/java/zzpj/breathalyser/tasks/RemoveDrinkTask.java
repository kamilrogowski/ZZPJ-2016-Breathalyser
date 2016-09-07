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
import zzpj.breathalyser.model.Drink;
import zzpj.breathalyser.model.User;
import zzpj.breathalyser.service.IUsersService;
import zzpj.breathalyser.service.SoberCalculator;

/**
 * Created by Krzychu on 07.09.2016.
 */
@Log
public class RemoveDrinkTask  extends TableCell<Drink, Boolean> {
    final Button removeButton = new Button("Remove");
    final StackPane paddedButton = new StackPane();
    final DoubleProperty buttonY = new SimpleDoubleProperty();

    public RemoveDrinkTask(final TableView table, User currentAccount, IUsersService usersService, SoberCalculator calculator) {
        paddedButton.setPadding(new Insets(3));
        paddedButton.getChildren().add(removeButton);
        removeButton.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                buttonY.set(mouseEvent.getScreenY());
            }
        });
        removeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                table.getSelectionModel().setCellSelectionEnabled(true);
                Drink drink = (Drink) table.getSelectionModel().getSelectedItem();
                    calculator.getListOfDrink().remove(drink);
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
