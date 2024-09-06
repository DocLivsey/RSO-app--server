package dclvs.rso_app_server.enteties.components;

import dclvs.rso_app_server.Constants;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;

import java.util.regex.Pattern;

@Slf4j
@Getter
@EqualsAndHashCode
@NoArgsConstructor
@Accessors(chain = true)
public class Password {

    private static final Pattern VALID_PASSWORD_FORM = Pattern.compile(
            "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\\\d)(?=.*[@#$%^&+=]).{8,}$",
            Pattern.CASE_INSENSITIVE
    );

    /* In server service-part of application password might save and manipulated in sha hash-code
     * Password will be transformed into hash-code in API service-part of application
     * and receives as hash in dto from app`s API service
     */
    private String password;

    public void setPassword(String password) {
        try {
            validatePassword(password);
            this.password = password;
        } catch (RuntimeException exception) {
            log.error(exception.getMessage(), exception);
        }
    }

    public Password(String password) {
        setPassword(password);
    }

    public static boolean isPasswordCorrect(String password) {
        return VALID_PASSWORD_FORM
                .matcher(password)
                .matches();
    }

    public void validatePassword(String password) throws RuntimeException {
        if (!isPasswordCorrect(password)) {
            throw new RuntimeException( // TODO: code my own password throwable exception
                    Constants.ANSI_RED_BACKGROUND +
                            "password form is not correct! Validation did not pass" +
                            Constants.RESET
            );
        } else {
            log.info(
                    Constants.ANSI_GREEN_BACKGROUND +
                            "password is correct! Validation passed successfully" +
                            Constants.RESET
            );
        }
    }

    public boolean matches(Password password) {
        return false;
    }

}
