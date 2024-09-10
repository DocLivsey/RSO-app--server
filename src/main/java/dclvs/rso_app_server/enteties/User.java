package dclvs.rso_app_server.enteties;

import dclvs.rso_app_server.enteties.components.Email;
import dclvs.rso_app_server.enteties.components.Password;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Calendar;
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

@Getter
enum Speciality {
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
        return returnableSpeciality.get();
    }
}

@Getter
enum Group {
    ThreeAM("3ПМ"), FourAM("4ПМ"),
    ThreeMM("3ММ"), FourMM("4ММ"),
    ThreeIT("3ИТ"), FourIT("4ИТ"),
    ELEVENTH("11"), TWELFTH("12"), THIRTEENTH("13"),
    TWENTY_FIRST("21"), TWENTY_SECOND("22"), TWENTY_THIRTEENTH("23");

    private final String titleRUS;

    Group(String titleRUS) {
        this.titleRUS = titleRUS;
    }

    public static Group fromTitle(String title) {
        AtomicReference<Group> returnableGroup = new AtomicReference<>();
        EnumSet.allOf(Group.class)
                .forEach(group -> {
                    if (group.getTitleRUS().strip().equalsIgnoreCase(
                            title.replaceAll(" ", "").strip())) {
                        returnableGroup.set(group);
                    }
                });
        return returnableGroup.get();
    }
}

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class User {

    private Long userId;

    private Email email;

    private Password password;

    private String firstName;

    private String surName;

    private String patronymicName;

    private Calendar birthday;

    private Faculty faculty;

    private Speciality speciality;

    private Integer course;

    private Group group;

}
