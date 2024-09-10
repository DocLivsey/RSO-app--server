package dclvs.rso_app_server.enteties.components;
import lombok.Getter;

import java.util.EnumSet;
import java.util.concurrent.atomic.AtomicReference;

/* TODO: replace enums to db`s entity-classes
 *   to allow CRUD manipulation with variable entities
 */
@Getter
enum Faculty {
    FCSnAM("ФКТиПМ");

    private final String titleRUS;

    Faculty(String titleRUS) {
        this.titleRUS = titleRUS;
    }

    public static Faculty fromTitle(String title) {
        AtomicReference<Faculty> returnableFaculty = new AtomicReference<>();
        EnumSet.allOf(Faculty.class) // all faculties from enum Faculty
                .forEach(faculty -> {
                    if (faculty.getTitleRUS().strip().equalsIgnoreCase(
                            title.replaceAll(" ", "").strip())) {
                        returnableFaculty.set(faculty);
                    }
                });
        return returnableFaculty.get();
    }
}
