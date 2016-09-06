package zzpj.breathalyser.service;

import javafx.collections.ObservableList;
import lombok.Getter;
import lombok.Setter;
import zzpj.breathalyser.initialization.MeetingDataInitializer;
import zzpj.breathalyser.model.Meeting;
import zzpj.breathalyser.repository.IMeetingRepository;
import zzpj.breathalyser.repository.MeetingRepository;

import java.util.List;

/**
 * Created by Magda Wojnarowicz on 04.09.2016.
 */
public class MeetingService implements IMeetingService {

    private IMeetingRepository meetingRepository = new MeetingRepository();

    @Override
    public ObservableList<Meeting> getAllEvents() {
        return meetingRepository.getAllEvents();
    }

    @Override
    public boolean createEvent(Meeting meeting) {
        return !meetingRepository.getAllEvents().contains(meeting) && meetingRepository.createEvent(meeting);
    }
}
