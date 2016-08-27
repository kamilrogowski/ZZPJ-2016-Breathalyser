package zzpj.breathalyser.model;


import lombok.Data;

import java.util.Date;
import java.util.Set;

/**
 * Created by Kamil Rogowski on 13.06.2016.
 */
@Data
public class UserAlcoholConsumed {

    private Date startTime;
    private Date endTime;
    private User userConnected;
    private Meeting meetingConnected;
    private Score scoreConnected;

    private Set<AlcoholConsumed> userAlcoholConsumed;

}
