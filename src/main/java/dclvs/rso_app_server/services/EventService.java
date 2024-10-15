package dclvs.rso_app_server.services;

import dclvs.rso_app_server.enteties.Event;
import dclvs.rso_app_server.enteties.EventsTable;
import dclvs.rso_app_server.mappers.EventMapper;
import dclvs.rso_app_server.repositories.EventRepository;
import lombok.AllArgsConstructor;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
@Accessors(chain = true)
public class EventService {

    private final EventMapper eventMapper;

    private final EventRepository eventRepository;

    public Event convertToEntity(EventsTable eventsTable) {
        return eventMapper.toEntity(eventsTable);
    }

    public EventsTable convertToDataSource(Event event) {
        return eventMapper.toDataSource(event);
    }

}
