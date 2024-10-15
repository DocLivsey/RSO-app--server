package dclvs.rso_app_server.services;

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

}
