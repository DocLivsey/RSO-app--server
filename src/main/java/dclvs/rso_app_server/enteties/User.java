package dclvs.rso_app_server.enteties;

import dclvs.rso_app_server.enteties.components.Email;
import dclvs.rso_app_server.enteties.components.Password;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import java.util.Calendar;

/* TODO: replace enums to db`s entity-classes
*   to allow CRUD manipulation with variable entities
*/
enum Faculty {

}

enum Speciality {

}

enum Group {

}

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class User {

    private Long user_id;

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
