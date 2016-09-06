package zzpj.breathalyser.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Created by Kamil Rogowski on 13.06.2016.
 */
@Data
public class Meeting {

    private String location;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private ObservableList<User> usersInMeeting = FXCollections.observableArrayList();

    public Meeting() {
    }

    public Meeting(String location, LocalDateTime today, LocalDateTime endTime, ObservableList<User> participants) {
        this.location = location;
        this.startTime = today;

        this.endTime = endTime;
        this.usersInMeeting = participants;
    }
}
