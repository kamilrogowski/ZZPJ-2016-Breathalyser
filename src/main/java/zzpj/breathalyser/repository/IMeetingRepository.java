package zzpj.breathalyser.repository;

import javafx.collections.ObservableList;
import zzpj.breathalyser.model.Meeting;

import java.util.List;

/**
 * Created by Magda Wojnarowicz on 04.09.2016.
 */
public interface IMeetingRepository {

     ObservableList<Meeting> getAllEvents();
      boolean createEvent(Meeting meeting);
}
