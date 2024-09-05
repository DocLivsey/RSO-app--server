package dclvs.rso_app_server.repositories;

import dclvs.rso_app_server.enteties.EventsTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface EventRepository extends JpaRepository<EventsTable, Long> {

    Optional<EventsTable> findByEventId(Long eventId);

    @Query("select e from EventsTable e")
    Optional<List<EventsTable>> findAllEvents();

}
