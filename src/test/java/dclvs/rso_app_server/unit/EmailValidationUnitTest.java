package dclvs.rso_app_server.unit;

import dclvs.rso_app_server.enteties.components.Email;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class EmailValidationUnitTest {

    @Test
    public void testToEmailValidation() {
        // Given
        String email1 = "@mail.io";
        String email2 = "@vova.list.com";
        String email3 = "vladimir@mail.com";
        String email4 = "vladimir.gmail.ru";
        String email5 = "vladimir@com";
        String email6 = "vlad.i.mir@edu.su";

        // Then
        Assertions.assertFalse(Email.isEmailCorrect(email1));
        Assertions.assertFalse(Email.isEmailCorrect(email2));
        Assertions.assertTrue(Email.isEmailCorrect(email3));
        Assertions.assertFalse(Email.isEmailCorrect(email4));
        Assertions.assertFalse(Email.isEmailCorrect(email5));
        Assertions.assertTrue(Email.isEmailCorrect(email6));
    }

}
