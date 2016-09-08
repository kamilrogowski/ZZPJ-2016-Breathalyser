package zzpj.breathalyser.service;

import javafx.collections.ObservableList;
import zzpj.breathalyser.model.Meeting;
import zzpj.breathalyser.repository.IMeetingRepository;
import zzpj.breathalyser.repository.MeetingRepository;

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
        return  meetingRepository.createEvent(meeting);
    }
}
