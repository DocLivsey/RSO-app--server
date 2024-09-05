package dclvs.rso_app_server.enteties;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "users_events")
public class UsersEventsTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UsersTable usersTable;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private EventsTable eventsTable;

}
