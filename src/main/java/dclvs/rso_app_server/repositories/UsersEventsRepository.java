package dclvs.rso_app_server.repositories;

import dclvs.rso_app_server.enteties.EventsTable;
import dclvs.rso_app_server.enteties.UsersEventsTable;
import dclvs.rso_app_server.enteties.UsersTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UsersEventsRepository extends JpaRepository<UsersEventsTable, Long> {

    @Query("select u from UsersEventsTable u where u.eventsTable == :eventsTable")
    Optional<List<UsersTable>> getUsersByEvents(@Param("eventsTable") EventsTable eventsTable);

}
