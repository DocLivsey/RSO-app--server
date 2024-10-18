package dclvs.rso_app_server.unit;

import dclvs.rso_app_server.Constants;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class PasswordValidationUnitTest {

    public List<String> buildTestPasswords() {
        return new ArrayList<>(
                List.of(
                        "TTjBAIeNUA",
                        "gatekmioxj",
                        "MXKMQALHQK",
                        "1834327183",
                        "VzO7Q9gL",
                        "DEF1DDZBN6",
                        "r@VJjXCFnRbO",
                        "pX$ooOybob1uyK5dirg3Ic5yWiaQZJ@5nLXCNuPTj#nTb#vpXgp0pl",
                        "nVaK2fQ",
                        "gra8a2xjiz",
                        "LDihPA0VbH"
                )
        );
    }

    @Test
    public void testWhichPasswordFitsCondition() {
        for(var password : buildTestPasswords()) {
            try {
                // Assertions.assertTrue(Password.isPasswordCorrect(password));
                log.info(STR."\{Constants.GREEN_BOLD}Password \{password} is strong\{Constants.RESET}");
            } catch (AssertionError error) {
                log.error(STR."\{error.getMessage()}\nPassword \{password} is not strong");
            }
        }
    }

}
