package dclvs.rso_app_server.controllers;

import dclvs.rso_app_server.enteties.User;
import dclvs.rso_app_server.services.AuthService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@AllArgsConstructor
@RestController("/user")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody User user) {
        return authService.signUpNewUser(user);
    }

    /* TODO: replace User -> UserDto and in AuthService make mapping UserDto into User
        and do query to database by UserRepository with User not UserDto */
    @GetMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        return authService.authenticate(user);
    }

    @GetMapping("/logout")
    public void logout() {

    }

}
