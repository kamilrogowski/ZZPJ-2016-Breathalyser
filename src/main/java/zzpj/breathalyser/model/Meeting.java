package zzpj.breathalyser.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import lombok.Data;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Kamil Rogowski on 13.06.2016.
 */
@Data
public class Meeting {

    private StringProperty location = new SimpleStringProperty();
    private DateFormat startTime = new SimpleDateFormat();
    private DateFormat endTime = new SimpleDateFormat();
    private Set<User> usersInMeeting = new HashSet<>();


    public final void setLocation(String value) {
        location.set(value);
    }

    public final String getLocation() {
        return location.get();
    }

    public final StringProperty locationProperty() {
        return location;
    }
}
