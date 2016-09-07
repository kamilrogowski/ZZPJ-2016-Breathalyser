package zzpj.breathalyser.controller;


import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
<<<<<<< HEAD
import javafx.scene.control.*;
=======
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
>>>>>>> aa6db9c01c9ccddcc54f65e985e700656b06b31d
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import lombok.Setter;
import lombok.extern.java.Log;
<<<<<<< HEAD
=======
import zzpj.breathalyser.Utils.FieldValidator;
>>>>>>> aa6db9c01c9ccddcc54f65e985e700656b06b31d
import zzpj.breathalyser.model.Drink;
import zzpj.breathalyser.model.Meeting;
import zzpj.breathalyser.model.User;
import zzpj.breathalyser.model.UserDetails;
import zzpj.breathalyser.service.IMeetingService;
import zzpj.breathalyser.service.IUsersService;
import zzpj.breathalyser.service.SoberCalculator;
import zzpj.breathalyser.tasks.AddFriendTask;
import zzpj.breathalyser.tasks.RemoveDrinkTask;

import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.ResourceBundle;

@Log
public class DashboardController implements Initializable {

    @Setter
    private IUsersService usersService;

    @Setter
    private IMeetingService meetingService;

    @Setter
    private User myAccount;

    @Setter
    private SoberCalculator calculator = new SoberCalculator();;
    /**
     * TODO Field for user login
     */
    @FXML private Text loginMessage;

    @FXML private TableView<User> allUsers;
    @FXML private TableColumn<User, String> loginColumn;
    @FXML private TableColumn<UserDetails, String> nameColumn;
    @FXML private TableColumn<UserDetails, String> surnameColumn;
    @FXML private TableColumn<User, String> phoneColumn;
    @FXML private TableColumn<User, Boolean> actionColumn;

    @FXML private TableView<User> myFriends;
    @FXML private TableColumn<User, String> friendLogin;
    @FXML private TableColumn<User, String> friendName;
    @FXML private TableColumn<User, String> friendSurname;

    @FXML private TableView<Meeting> myMeetings;
    @FXML private TableColumn<Meeting, String> meetingLocationColumn;
    @FXML private TableColumn<Meeting, Date> meetingStartTimeColumn;
    @FXML private TableColumn<Meeting, Date> meetingEndTimeColumn;
    @FXML private TableColumn<Meeting, User> meetingParticipants;

    @FXML private TextField addLocation;
    @FXML private TextField addStartTime;
    @FXML private TextField addEndTime;

    @FXML private TableView<User> friendsInEvents;
    @FXML private TableColumn<User, String> eventUserName;
    @FXML private TableColumn<User, String> eventUserSurname;

<<<<<<< HEAD
    @FXML private TableView<User> drinks;
    @FXML private TableColumn<Drink, String> nameOfDrinkColumn;
    @FXML private TableColumn<Drink, Double> volumeOfDrinkInMlColumn;
    @FXML private TableColumn<Drink, Double> percentageOfEthanolInDrinkColumn;
=======
    @FXML private TableView<Drink> drinks;
    @FXML private TableColumn<Drink, String> nameOfDrinkColumn;
    @FXML private TableColumn<Drink, Double> volumeOfDrinkInMlColumn;
    @FXML private TableColumn<Drink, Double> percentageOfEthanolInDrinkColumn;
    @FXML private TableColumn<Drink, Boolean> removeColumn;
>>>>>>> aa6db9c01c9ccddcc54f65e985e700656b06b31d

    @FXML private TextField nameOfDrink;
    @FXML private TextField volumeInMl;
    @FXML private TextField percentage;

    @FXML private TextField permille;
<<<<<<< HEAD
    SoberCalculator calculator = new SoberCalculator();
=======
>>>>>>> aa6db9c01c9ccddcc54f65e985e700656b06b31d

    @Override
    @FXML
    public void initialize(URL location, ResourceBundle resources) {
        initUsersColumn();
        initMyFriendsColumn();
        initMyMeetingsColumn();
        initFriendsInEvents();
        initDrinksColumn();
    }

    public void initUserList() {
        allUsers.setItems(usersService.getAllUsers());
        myFriends.setItems(myAccount.getFriends());
        myMeetings.setItems(meetingService.getAllEvents());
    }

    private void initUsersColumn() {
        loginColumn.setCellValueFactory(new PropertyValueFactory<>("login"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        surnameColumn.setCellValueFactory(new PropertyValueFactory<>("surname"));
        phoneColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        actionColumn.setCellValueFactory(features -> new SimpleBooleanProperty(features.getValue() != null));
        actionColumn.setCellFactory(personBooleanTableColumn -> new AddFriendTask(allUsers, myAccount, usersService,friendsInEvents));
    }

    private void initMyMeetingsColumn() {
        meetingLocationColumn.setCellValueFactory(new PropertyValueFactory<>("location"));
        meetingStartTimeColumn.setCellValueFactory(new PropertyValueFactory<>("startTime"));
        meetingEndTimeColumn.setCellValueFactory(new PropertyValueFactory<>("endTime"));
        meetingParticipants.setCellValueFactory(new PropertyValueFactory<>("usersInMeeting"));
    }

    private void initMyFriendsColumn() {
        friendName.setCellValueFactory(new PropertyValueFactory<>("name"));
        friendSurname.setCellValueFactory(new PropertyValueFactory<>("surname"));
        friendLogin.setCellValueFactory(new PropertyValueFactory<>("login"));
    }

    public void addEvent() {

        Meeting meeting = new Meeting();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        final String startTimeString = addStartTime.getText();
        final String endTimeString = addEndTime.getText();

        LocalDateTime startTime = LocalDateTime.parse(startTimeString, formatter);
        LocalDateTime endTime = LocalDateTime.parse(endTimeString, formatter);
        meeting.setStartTime(startTime);
        meeting.setEndTime(endTime);
        meeting.setLocation(addLocation.getText());
        final ObservableList<User> selectedCells = friendsInEvents.getSelectionModel().getSelectedItems();
        meeting.setUsersInMeeting(selectedCells);
        for (User user: selectedCells) {
            if(user != null){
                usersService.removeUserAvailableFromEvent(user);
            }
        }
        System.out.println(selectedCells);

        meetingService.createEvent(meeting);


    }

    private void initFriendsInEvents() {
        eventUserName.setCellValueFactory(new PropertyValueFactory<>("name"));
        eventUserSurname.setCellValueFactory(new PropertyValueFactory<>("surname"));
        friendsInEvents.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }


    private void initDrinksColumn() {
        nameOfDrinkColumn.setCellValueFactory(new PropertyValueFactory<>("nameOfDrink"));
        volumeOfDrinkInMlColumn.setCellValueFactory(new PropertyValueFactory<>("volumeOfDrinkInMl"));
        percentageOfEthanolInDrinkColumn.setCellValueFactory(new PropertyValueFactory<>("percentageOfEthanolInDrinkC"));
    }

    public void addDrink(){
        Drink drink = new Drink(nameOfDrink.getText(), new Double(volumeInMl.getText()), new Double(percentage.getText()));
        calculator.addDrinkToListOfDrink(drink);
        double drinkingPeriodInHours = ChronoUnit.HOURS.between(meetingService.getAllEvents().get(myMeetings.getSelectionModel().getSelectedIndex()).getStartTime(),  meetingService.getAllEvents().get(myMeetings.getSelectionModel().getSelectedIndex()).getEndTime());
        Double currentPermille = calculator.getEstimatedPeakBloodAlcoholConcentration(myAccount.getUserDetails(), drinkingPeriodInHours);
        permille.setText(currentPermille.toString());
    }

    private void initDrinksColumn() {
        nameOfDrinkColumn.setCellValueFactory(new PropertyValueFactory<>("nameOfDrink"));
        volumeOfDrinkInMlColumn.setCellValueFactory(new PropertyValueFactory<>("volumeOfDrinkInMl"));
        percentageOfEthanolInDrinkColumn.setCellValueFactory(new PropertyValueFactory<>("percentageOfEthanolInDrinkC"));
    }

    public void addDrink(){
        Drink drink = new Drink(nameOfDrink.getText(), new Double(volumeInMl.getText()), new Double(percentage.getText()));
        calculator.addDrinkToListOfDrink(drink);
        nameOfDrinkColumn.setCellValueFactory(new PropertyValueFactory<Drink, String>("nameOfDrink"));
        volumeOfDrinkInMlColumn.setCellValueFactory(new PropertyValueFactory<Drink, Double>("volumeOfDrinkInMl"));
        percentageOfEthanolInDrinkColumn.setCellValueFactory(new PropertyValueFactory<Drink, Double>("percentageOfEthanolInDrink"));
        removeColumn.setCellFactory(drinkBooleanTableColumn -> new RemoveDrinkTask(drinks, myAccount, usersService, this.calculator));
        drinks.setItems(calculator.getListOfDrink());
    }

    public void calculatePermilles(){
        double drinkingPeriodInHours = ChronoUnit.HOURS.between(meetingService.getAllEvents().get(myMeetings.getSelectionModel().getSelectedIndex()).getStartTime(),  meetingService.getAllEvents().get(myMeetings.getSelectionModel().getSelectedIndex()).getEndTime());
        Double currentPermille = calculator.getEstimatedPeakBloodAlcoholConcentration(myAccount.getUserDetails(), drinkingPeriodInHours);
        if(currentPermille>=0)permille.setText(currentPermille.toString());
        else permille.setText("0.0");
    }

}
