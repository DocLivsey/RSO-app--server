package dclvs.rso_app_server.enteties;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import lombok.Data;

@Data
public class UsersEventsTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "user_id")
    private UsersTable usersTable;

    @JoinColumn(name = "event_id")
    private EventsTable eventsTable;

}
