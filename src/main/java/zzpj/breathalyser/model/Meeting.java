package zzpj.breathalyser.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Observable;
import java.util.Set;

/**
 * Created by Kamil Rogowski on 13.06.2016.
 */
@Data
public class Meeting {

    private String location;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private ObservableList<User> usersInMeeting = FXCollections.observableArrayList();

    public Meeting(String location, LocalDateTime today, LocalDateTime endTime, ObservableList<User> participants) {
        this.location = location;
        this.startTime = today;
        this.endTime = endTime;
        this.usersInMeeting = participants;
    }
}
