package dclvs.rso_app_server.mappers;

import dclvs.rso_app_server.entities.User;
import dclvs.rso_app_server.datasources.UsersTable;
import dclvs.rso_app_server.entities.components.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mappings({
            @Mapping(target = "email", source = "email", qualifiedByName = "stringToEmail"),
            @Mapping(target = "password", source = "password", qualifiedByName = "stringToPassword"),
            @Mapping(target = "faculty", source = "faculty", qualifiedByName = "stringToFaculty"),
            @Mapping(target = "speciality", source = "speciality", qualifiedByName = "stringToSpeciality"),
            @Mapping(target = "group", source = "group", qualifiedByName = "stringToGroup"),
    })
    User toEntity(UsersTable usersTable);

    @Mappings({
            @Mapping(target = "email", source = "email", qualifiedByName = "mapEmail"),
            @Mapping(target = "password", source = "password", qualifiedByName = "mapPassword"),
            @Mapping(target = "faculty", source = "faculty", qualifiedByName = "mapFaculty"),
            @Mapping(target = "speciality", source = "speciality", qualifiedByName = "mapSpeciality"),
            @Mapping(target = "group", source = "group", qualifiedByName = "mapGroup"),
    })
    UsersTable toDataSource(User user);

    @Named("mapEmail")
    default String map(Email email) {
        return  email != null ? email.getEmail() : null;
    }

    @Named("mapPassword")
    default String map(Password password) {
        return password != null ? password.getPassword() : null;
    }

    @Named("mapFaculty")
    default String map(Faculty faculty) {
        return faculty != null ? faculty.getTitleRUS() : null;
    }

    @Named("mapSpeciality")
    default String map(Speciality speciality) {
        return speciality != null ? speciality.getTitleRUS() : null;
    }

    @Named("mapGroup")
    default String map(Group group) {
        return group != null ? group.getTitleRUS() : null;
    }

    @Named("stringToEmail")
    default Email stringToEmail(String email) {
        return new Email(email);
    }

    @Named("stringToPassword")
    default Password stringToPassword(String password) {
        return new Password(password);
    }

    @Named("stringToFaculty")
    default Faculty stringToFaculty(String facultyTitleRUS) {
        return Faculty.fromTitle(facultyTitleRUS);
    }

    @Named("stringToSpeciality")
    default Speciality stringToSpeciality(String specialityTitleRUS) {
        return Speciality.fromTitle(specialityTitleRUS);
    }

    @Named("stringToGroup")
    default Group stringToGroup(String groupTitleRUS) {
        return Group.fromTitle(groupTitleRUS);
    }

}
