package dclvs.rso_app_server.unit;

import dclvs.rso_app_server.entities.components.Password;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class PasswordCompareUnitTest {

    private static final Logger log = LoggerFactory.getLogger(PasswordCompareUnitTest.class);

    @Test
    public void testingPasswordsCorrectHashing() throws NoSuchAlgorithmException {
        // Given
        Password password = new Password("wS8wF5Fdi$o8@i7LjuoVW5sLON#gIzB");

        // When
        long hashedPassword = password.hashCode();

        // Then
        long againHashedPassword = password.hashCode();
        log.info("first time hashed {}, second time hashed {}", hashedPassword, againHashedPassword);
        Assertions.assertEquals(hashedPassword, againHashedPassword);
    }

    @Test
    public void testToPasswordCompare() {
        // Given
        Password[] passwords = buildTestPasswords();

        // When
        List<Integer> hashedPasswords = Arrays
                .stream(passwords)
                .map(Password::hashCode)
                .toList();

        // Then
        IntStream.range(0, hashedPasswords.size())
                .forEach(index -> {
                    Integer hashedPassword = passwords[index].hashCode();
                    log.info("first time hashed {}, second time hashed {}",
                            hashedPasswords.get(index),
                            hashedPassword);
                    Assertions.assertEquals(
                            hashedPasswords.get(index),
                            hashedPassword
                    );
                });
    }

    @Test
    public void testToPasswordMatching()  {
        // Given
        Password[] passwords = buildTestPasswords();

        // When
        List<Integer> hashedPasswords = Arrays
                .stream(passwords)
                .map(Password::hashCode)
                .toList();

        // Then
        IntStream.range(0, hashedPasswords.size())
                .forEach(index -> {
                    Integer hashedPassword = passwords[index].hashCode();
                    log.info("first time hashed {}, second time hashed {}",
                            hashedPasswords.get(index),
                            hashedPassword);
                    Assertions.assertTrue(passwords[index].matches(hashedPasswords.get(index)));
                });
    }

    private Password[] buildTestPasswords() {
        return new Password[] {
                new Password("a@6qUh3QB9yfQN"),
                new Password("wS8wF5Fdi$o8@i7LjuoVW5sLON#gIzB"),
                new Password("6Zle5dB5$xa8UullSMe7oo3SpEfDdziSO$xedNog"),
                new Password("cTVyi6Dz2@ovlTaD"),
        };
    }

}
