package dclvs.rso_app_server.enteties;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Calendar;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class UsersTable {

    @Id
    @GeneratedValue
    private Long user_id;

    private String email;

    private String password;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "surname")
    private String surName;

    @Column(name = "patronymic")
    private String patronymicName;

    @Temporal(TemporalType.DATE)
    private Calendar birthday;

    private String faculty;

    private String speciality;

    private Integer course;

    private String group;

}
