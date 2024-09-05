package dclvs.rso_app_server.enteties;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Calendar;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "events")
public class EventsTable {

    @Id
    @GeneratedValue
    private Long event_id;

    @Column(name = "tag_name")
    private String tagName;

    private String description;

    @Temporal(TemporalType.DATE)
    @Column(name = "scheduled_date")
    private Calendar scheduledDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "begin_at")
    private Calendar beginAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ends_at")
    private Calendar endsAt;



}
