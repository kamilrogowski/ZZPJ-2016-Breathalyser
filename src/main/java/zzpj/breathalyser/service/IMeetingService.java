package zzpj.breathalyser.service;

import javafx.collections.ObservableList;
import zzpj.breathalyser.model.Meeting;

/**
 * Created by Magda Wojnarowicz on 04.09.2016.
 */
public interface IMeetingService {
    ObservableList<Meeting> getAllEvents();
    boolean createEvent(Meeting meeting);
}
