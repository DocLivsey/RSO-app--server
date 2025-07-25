package dclvs.rso_app_server.entities.components;

import lombok.Getter;

import java.util.EnumSet;
import java.util.concurrent.atomic.AtomicReference;

@Getter
public enum Speciality {
    UNDEFINED("undefined"),
    AMnCS("ПМИ"), // Applied Math an Information
    MS("МО"), // Math Support
    AI("ПИ"); // Applied Informatics

    private final String titleRUS;

    Speciality(String titleRUS) {
        this.titleRUS = titleRUS;
    }

    public static Speciality fromTitle(String title) {
        AtomicReference<Speciality> returnableSpeciality = new AtomicReference<>();
        EnumSet.allOf(Speciality.class)
                .forEach(speciality -> {
                    if (speciality.getTitleRUS().strip().equalsIgnoreCase(
                            title.replaceAll(" ", "").strip())) {
                        returnableSpeciality.set(speciality);
                    }
                });
        return returnableSpeciality.get() != null ? returnableSpeciality.get() : UNDEFINED;
    }
}
