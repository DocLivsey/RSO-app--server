package dclvs.rso_app_server.repositories;

import dclvs.rso_app_server.entities.EventsTable;
import dclvs.rso_app_server.entities.UsersEventsTable;
import dclvs.rso_app_server.entities.UsersTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UsersEventsRepository extends JpaRepository<UsersEventsTable, Long> {

    @Query("select ue.usersTable from UsersEventsTable ue where ue.eventsTable = :eventsTable")
    Optional<List<UsersTable>> findUsersByEvent(@Param("eventsTable") EventsTable eventsTable);

    @Query("select ue.eventsTable from UsersEventsTable ue where ue.usersTable = :usersTable")
    Optional<List<EventsTable>> findUserEvents(@Param("usersTable") UsersTable usersTable);

}
