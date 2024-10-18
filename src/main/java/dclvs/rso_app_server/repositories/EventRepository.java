package dclvs.rso_app_server.repositories;

import dclvs.rso_app_server.entities.EventsTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

public interface EventRepository extends JpaRepository<EventsTable, Long> {

    Optional<EventsTable> findByEventId(Long eventId);

    @Query("select e from EventsTable e")
    Optional<List<EventsTable>> findAllEvents();

    @Query("select e from EventsTable e where e.beginAt = :date")
    Optional<List<EventsTable>> findAllEventsByDate(@Param("date") Calendar date);

    void deleteByEventId(Long eventId);

}
