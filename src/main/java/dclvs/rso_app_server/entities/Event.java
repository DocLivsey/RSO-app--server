package dclvs.rso_app_server.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Calendar;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Event {

    private Long eventId;

    private String tagName;

    private String description;

    private Calendar scheduledDate;

    private Calendar beginAt;

    private Calendar endsAt;

}
