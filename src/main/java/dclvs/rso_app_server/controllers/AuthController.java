package dclvs.rso_app_server.controllers;

import dclvs.rso_app_server.services.AuthService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@AllArgsConstructor
public class AuthController {

    private final AuthService authService;

    public void signup() {

    }

    public void login() {

    }

    public void logout() {

    }

}
