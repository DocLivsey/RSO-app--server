package dclvs.rso_app_server.services;

import dclvs.rso_app_server.enteties.User;
import dclvs.rso_app_server.enteties.UsersTable;
import dclvs.rso_app_server.mappers.UserMapper;
import dclvs.rso_app_server.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
@Accessors(chain = true)
public class UserService {

    private final UserMapper userMapper;

    private final UserRepository userRepository;

    private UsersTable convertToUsersTable(User user) {
        return userMapper.toDataSource(user);
    }

    private User convertToUser(UsersTable usersTable) {
        return userMapper.toEntity(usersTable);
    }

}
