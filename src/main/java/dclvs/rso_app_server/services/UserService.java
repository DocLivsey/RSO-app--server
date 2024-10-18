package dclvs.rso_app_server.services;

import dclvs.rso_app_server.Constants;
import dclvs.rso_app_server.datasources.EventsTable;
import dclvs.rso_app_server.entities.User;
import dclvs.rso_app_server.datasources.UsersTable;
import dclvs.rso_app_server.mappers.UserMapper;
import dclvs.rso_app_server.repositories.EventRepository;
import dclvs.rso_app_server.repositories.UserRepository;
import dclvs.rso_app_server.repositories.UsersEventsRepository;
import lombok.AllArgsConstructor;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.rmi.NoSuchObjectException;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

@Slf4j
@Service
@AllArgsConstructor
@Accessors(chain = true)
public class UserService {

    private final UserMapper userMapper;

    private final UserRepository userRepository;

    private final EventRepository eventRepository;

    private final UsersEventsRepository usersEventsRepository;

    public UsersTable convertToUsersTable(User user) {
        return userMapper.toDataSource(user);
    }

    public User convertToUser(UsersTable usersTable) {
        return userMapper.toEntity(usersTable);
    }

    public Optional<List<User>> allUsersOnEvent(Long eventId) throws Throwable {
        EventsTable eventsTable = eventRepository
                .findById(eventId)
                .orElseThrow((Supplier<Throwable>) () -> new NoSuchObjectException(
                        STR."\{Constants.ERROR}No such event by id: \{eventId} in system\{Constants.RESET}"
                ));
        return Optional.of(usersEventsRepository
                .findUsersByEvent(eventsTable)
                .stream()
                .flatMap(Collection::stream)
                .map(userMapper::toEntity)
                .toList()
        );
    }

}
