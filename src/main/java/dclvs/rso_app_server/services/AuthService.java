package dclvs.rso_app_server.services;

import dclvs.rso_app_server.Constants;
import dclvs.rso_app_server.enteties.User;
import dclvs.rso_app_server.enteties.UsersTable;
import dclvs.rso_app_server.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.rmi.NoSuchObjectException;
import java.util.function.Supplier;

@Slf4j
@Service
@AllArgsConstructor
public class AuthService {

    private UserRepository userRepository;

    public ResponseEntity<?> authenticate(User user) {
        try {
            UsersTable usersTable = identification(user);
            return ResponseEntity.ok(usersTable);
        } catch (Throwable throwable) {
            return ResponseEntity
                    .badRequest()
                    .body(throwable.getMessage());
        }
    }

    public UsersTable identification(User user) throws Throwable {
        return userRepository
                .findByUserId(user.getUserId())
                .orElseThrow((Supplier<Throwable>) () -> new NoSuchObjectException(
                        STR."\{Constants.ERROR}No such user: \{user} in system\{Constants.RESET}"
                ));
    }

}
