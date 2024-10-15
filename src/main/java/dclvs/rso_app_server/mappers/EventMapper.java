package dclvs.rso_app_server.mappers;

import dclvs.rso_app_server.enteties.Event;
import dclvs.rso_app_server.enteties.EventsTable;

public interface EventMapper {

    Event toEntity(EventsTable dataSource);

    EventsTable toDataSource(Event entity);

}
