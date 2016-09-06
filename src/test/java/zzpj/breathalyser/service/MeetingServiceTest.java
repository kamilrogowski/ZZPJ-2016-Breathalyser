package zzpj.breathalyser.service;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.Assert;
import org.junit.Test;
import zzpj.breathalyser.model.Meeting;
import zzpj.breathalyser.model.User;
import zzpj.breathalyser.model.UserDetails;
import java.time.LocalDateTime;

/**
 * Created by Magda Wojnarowicz on 2016-09-06.
 */
public class MeetingServiceTest {
    @Test
    public void getAllEvents() throws Exception {

        MeetingService meetingService = new MeetingService();
        int actual = meetingService.getAllEvents().size();
        int expected = 5;
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void createEvent() throws Exception {

        MeetingService meetingService = new MeetingService();
        LocalDateTime startTime = LocalDateTime.of(2016, 10, 10, 10, 10);
        LocalDateTime endTime = LocalDateTime.of(2016, 10, 10, 11, 11);
        UserDetails userDetails = new UserDetails(80, 170, 30, true);
        User user = new User("login", "password", "email", "name", "surname", userDetails);
        ObservableList<User> participants = FXCollections.observableArrayList();
        participants.add(user);
        Meeting meeting = new Meeting("Domek dla lalek", startTime, endTime, participants);
        boolean actual = meetingService.createEvent(meeting);
        boolean expected = true;
        Assert.assertEquals(expected, actual);

    }
}

