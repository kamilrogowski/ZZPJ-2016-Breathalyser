package zzpj.breathalyser.repository;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import zzpj.breathalyser.initialization.MeetingDataInitializer;
import zzpj.breathalyser.model.Meeting;

/**
 * Created by Magda Wojnarowicz on 04.09.2016.
 */
public class MeetingRepository implements IMeetingRepository {

    private ObservableList<Meeting> allMeetings = FXCollections.observableArrayList();

    public MeetingRepository() {
        allMeetings.addAll(new MeetingDataInitializer().generateMeetings());
    }

    @Override
    public ObservableList<Meeting> getAllEvents() {
        return allMeetings;
    }

    @Override
    public boolean createEvent(Meeting meeting) {
        return allMeetings.add(meeting);
    }
}
