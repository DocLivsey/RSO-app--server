package dclvs.rso_app_server.entities.components;

import lombok.*;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

@Data
@Slf4j
@EqualsAndHashCode
@AllArgsConstructor
@Accessors(chain = true)
public class Password {

    /* In server service-part of application password might save and manipulated in sha hash-code
     * Password will be transformed into hash-code in API service-part of application
     * and receives as hash in dto from app`s API service
     */
    private String password;

    // TODO: this method of hashing has been found not to comply with the determinism requirement
    public byte[] mocPasswordHashing() throws NoSuchAlgorithmException {
        // Generating salt (key)
        SecureRandom secureRandom = new SecureRandom();
        byte[] salt = new byte[16];
        secureRandom.nextBytes(salt);

        // Hashing password
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-512");
        messageDigest.update(salt);
        return messageDigest.digest(password.getBytes());
    }

    public boolean matches(Password password) {
        return hashCode() == password.hashCode();
    }

    public boolean matches(String password) {
        return matches(new Password(password));
    }

    public boolean matches(int password) {
        return hashCode() == password;
    }

}
