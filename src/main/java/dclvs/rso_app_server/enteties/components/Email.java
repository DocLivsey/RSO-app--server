package dclvs.rso_app_server.enteties.components;

import dclvs.rso_app_server.Constants;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;

import java.util.regex.Pattern;

@Slf4j
@Getter
@NoArgsConstructor
@Accessors(chain = true)
public class Email {

    private static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile(
            "^[A-Za-z0-9+_.-]+@(.+)$",
            Pattern.CASE_INSENSITIVE
    );

    private String email;

    public void setEmail(String email) {
        try {
            validateEmail(email);
            this.email = email;
        } catch (RuntimeException exception) {
            log.error(exception.getMessage(), exception);
        }
    }

    public Email(String email) {
        setEmail(email);
    }

    public static boolean isEmailCorrect(String email) {
        return VALID_EMAIL_ADDRESS_REGEX
                .matcher(email)
                .matches();
    }

    public void validateEmail(String email) throws RuntimeException {
        if (!isEmailCorrect(email)) {
            throw new RuntimeException( // TODO: code my own email throwable exception
                    Constants.ANSI_RED_BACKGROUND +
                    "email form is not correct! Validation did not pass" +
                    Constants.RESET
            );
        } else {
            log.info(
                    Constants.ANSI_GREEN_BACKGROUND +
                    "email is correct! Validation passed successfully" +
                    Constants.RESET
            );
        }
    }

}
