package dclvs.rso_app_server.controllers;

import dclvs.rso_app_server.Constants;
import dclvs.rso_app_server.entities.User;
import dclvs.rso_app_server.services.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.rmi.NoSuchObjectException;
import java.util.List;
import java.util.function.Supplier;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @GetMapping("/all")
    public ResponseEntity<?> allUsersOnEvent(@RequestParam("eventId") Long eventId) {
        try {
            List<User> users = userService
                    .allUsersOnEvent(eventId)
                    .orElseThrow(
                            (Supplier<Throwable>) () -> new NoSuchObjectException(
                                    STR."\{Constants.ERROR}There are no users on event with id: \{eventId}\{Constants.RESET}"
                            )
                    );
            return ResponseEntity.ok(users);
        } catch (NoSuchObjectException exception) {
            return ResponseEntity.notFound().build();
        } catch (Throwable throwable) {
            return ResponseEntity.internalServerError().body(throwable);
        }
    }

}
