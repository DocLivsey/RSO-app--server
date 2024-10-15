package dclvs.rso_app_server.mappers;

import dclvs.rso_app_server.enteties.Event;
import dclvs.rso_app_server.enteties.EventsTable;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

public interface EventMapper {

    @Mappings({
            @Mapping(source = "eventId", target = "eventId"),
            @Mapping(source = "tagName", target = "tagName"),
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "scheduledDate", target = "scheduledDate"),
            @Mapping(source = "beginAt", target = "beginAt"),
            @Mapping(source = "endsAt", target = "endsAt")
    })
    Event toEntity(EventsTable dataSource);

    @Mappings({
            @Mapping(source = "eventId", target = "eventId"),
            @Mapping(source = "tagName", target = "tagName"),
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "scheduledDate", target = "scheduledDate"),
            @Mapping(source = "beginAt", target = "beginAt"),
            @Mapping(source = "endsAt", target = "endsAt")
    })
    EventsTable toDataSource(Event entity);

}
