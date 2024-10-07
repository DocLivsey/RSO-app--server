package dclvs.rso_app_server.mappers;

import dclvs.rso_app_server.enteties.User;
import dclvs.rso_app_server.enteties.UsersTable;
import dclvs.rso_app_server.enteties.components.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

@Mapper
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
            @Mapping(target = "email", source = "email", expression = "java(user.getEmail().getEmail())"),
            @Mapping(target = "password", source = "password", expression = "java(user.getPassword().getPassword())"),
            @Mapping(target = "faculty", source = "faculty", expression = "java(user.getFaculty().name())"),
            @Mapping(target = "speciality", source = "speciality", expression = "java(user.getSpeciality().name())"),
            @Mapping(target = "group", source = "group", expression = "java(user.getGroup().name())"),
    })
    UsersTable toUsersTable(User user);

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
