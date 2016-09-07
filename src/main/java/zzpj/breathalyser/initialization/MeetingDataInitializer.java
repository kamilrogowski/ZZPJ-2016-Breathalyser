package zzpj.breathalyser.initialization;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lombok.extern.java.Log;
import zzpj.breathalyser.model.Meeting;
import zzpj.breathalyser.model.User;

import java.time.LocalDateTime;

/**
 * Created by Magda Wojnarowicz on 04.09.2016.
 */
@Log
public class MeetingDataInitializer {

    private final int MEETING_SIZE = 5;
    private final int PARTICIPANTS_SIZE = 0;

    private ObservableList<Meeting> meetings = FXCollections.observableArrayList();
    private ObservableList<User> participants = FXCollections.observableArrayList();

    public ObservableList<Meeting> generateMeetings() {
        for (int i = 0; i < MEETING_SIZE; i++) {
            meetings.add(generateMeetingData(i));
            log.info("Event in " + meetings.get(i).getLocation() + " has been created");
        }
        return meetings;
    }

    private Meeting generateMeetingData(int i) {
        String location = "location " + i;
        LocalDateTime today = LocalDateTime.now();
        LocalDateTime endTime = today.plusDays(i);
        participants.add(new UserDataInitializer().generateUser(i));
        return new Meeting(location, today, endTime, participants);
    }


}
