package zzpj.breathalyser.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import lombok.Data;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Kamil Rogowski on 13.06.2016.
 */
@Data
public class Meeting {

    private String location;
    private Date startTime;
    private Date endTime;
    private Set<User> usersInMeeting = new HashSet<>();

}
