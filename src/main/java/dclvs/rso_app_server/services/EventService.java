package dclvs.rso_app_server.services;

import dclvs.rso_app_server.enteties.Event;
import dclvs.rso_app_server.enteties.EventsTable;
import dclvs.rso_app_server.mappers.EventMapper;
import dclvs.rso_app_server.repositories.EventRepository;
import dclvs.rso_app_server.repositories.UsersEventsRepository;
import lombok.AllArgsConstructor;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
@Accessors(chain = true)
public class EventService {

    private final EventMapper eventMapper;

    private final EventRepository eventRepository;

    private final UsersEventsRepository usersEventsRepository;

    public Event convertToEntity(EventsTable eventsTable) {
        return eventMapper.toEntity(eventsTable);
    }

    public EventsTable convertToDataSource(Event event) {
        return eventMapper.toDataSource(event);
    }

    public Optional<List<Event>> findAllEventsByDate(Calendar date) {
        return Optional.of(eventRepository
                .findAllEventsByDate(date)
                .stream()
                .flatMap(Collection::stream)
                .map(eventMapper::toEntity)
                .collect(Collectors.toList())
        );
    }

    public void createNewEvent(Event event) {
        eventRepository.saveAndFlush(eventMapper.toDataSource(event));
    }
    public void removeEvent(Long eventId) {
        eventRepository.deleteById(eventId);
    }

}
