package dclvs.rso_app_server.services;

import dclvs.rso_app_server.Constants;
import dclvs.rso_app_server.enteties.User;
import dclvs.rso_app_server.enteties.UsersTable;
import dclvs.rso_app_server.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.rmi.NoSuchObjectException;
import java.util.function.Supplier;

@Slf4j
@Service
@AllArgsConstructor
public class AuthService {

    private UserRepository userRepository;

    public void authenticate(User user) throws Throwable {
        UsersTable usersTable = userRepository
                .findByUserId(user.getUserId())
                .orElseThrow((Supplier<Throwable>) () -> new NoSuchObjectException(
                                STR."\{Constants.ERROR}No such user: \{user} in system\{Constants.RESET}"
                        ));
    }

}
