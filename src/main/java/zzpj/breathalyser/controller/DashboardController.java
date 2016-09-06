package zzpj.breathalyser.controller;


import com.sun.javafx.css.converters.StringConverter;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.beans.property.*;
import javafx.util.converter.DateTimeStringConverter;
import javafx.util.converter.LocalDateTimeStringConverter;
import lombok.Setter;
import lombok.extern.java.Log;
import zzpj.breathalyser.Utils.FieldValidator;
import zzpj.breathalyser.model.Meeting;
import zzpj.breathalyser.model.User;
import zzpj.breathalyser.model.UserDetails;
import zzpj.breathalyser.repository.IMeetingRepository;
import zzpj.breathalyser.service.IMeetingService;
import zzpj.breathalyser.service.IUsersService;
import zzpj.breathalyser.tasks.AddFriendTask;

import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashSet;
import java.util.ResourceBundle;

@Log
public class DashboardController implements Initializable{

    @Setter
    private IUsersService usersService;

    @Setter
    private IMeetingService meetingService;

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
    @FXML private TableColumn<User, String> phoneColumn;
    @FXML private TableColumn<User, Boolean> actionColumn;

    @FXML private TableView<User> myFriends;
    @FXML private TableColumn<User, String> friendLogin;
    @FXML private TableColumn<User, String> friendName;
    @FXML private TableColumn<User, String> friendSurname;
    @FXML private TableColumn<User, String> friendPhoneNumber;

    @FXML private TableView<Meeting> myMeetings;
    @FXML private TableColumn<Meeting, String>  meetingLocationColumn;
    @FXML private TableColumn<Meeting, Date>  meetingStartTimeColumn;
    @FXML private TableColumn<Meeting, Date>  meetingEndTimeColumn;
    @FXML private TableColumn<Meeting, User>  meetingParticipants;

    @FXML private TextField addLocation;
    @FXML private TextField addStartTime;
    @FXML private TextField addEndTime;

    @Override
    @FXML
    public void initialize(URL location, ResourceBundle resources) {
        initUsersColumn();
        initMyFriendsColumn();
        initMyMeetingsColumn();
    }

    public void initUserList(){
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
        actionColumn.setCellFactory(personBooleanTableColumn -> new AddFriendTask(allUsers, myAccount));
    }

    private void initMyMeetingsColumn() {
        meetingLocationColumn.setCellValueFactory(new PropertyValueFactory<>("location"));
        meetingStartTimeColumn.setCellValueFactory(new PropertyValueFactory<>("startTime"));
        meetingEndTimeColumn.setCellValueFactory(new PropertyValueFactory<>("endTime"));
        meetingParticipants.setCellValueFactory(new PropertyValueFactory<>("usersInMeeting"));
    }

    private void initMyFriendsColumn(){
        friendLogin.setCellValueFactory(new PropertyValueFactory<>("login"));
        friendName.setCellValueFactory(new PropertyValueFactory<>("name"));
        friendSurname.setCellValueFactory(new PropertyValueFactory<>("surname"));
        friendPhoneNumber.setCellValueFactory(new PropertyValueFactory<>("phone"));
    }

    public void addEvent(){

        Meeting meeting = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime startTime = LocalDateTime.parse(addStartTime.getText(), formatter);
        LocalDateTime endTime = LocalDateTime.parse(addEndTime.getText(), formatter);

        if(checkDateTime())
            meeting.setStartTime(startTime);

        meetingService.createEvent(meeting);

    }
private boolean checkDateTime(){

       return FieldValidator.isDateTimeValid(addStartTime.getText())
               && FieldValidator.isDateTimeValid(addEndTime.getText());
    }

}
