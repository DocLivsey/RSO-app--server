package dclvs.rso_app_server.mappers;

import dclvs.rso_app_server.enteties.User;
import dclvs.rso_app_server.enteties.UsersTable;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface UserMapper {

    @Mappings({
            @Mapping(target = "email", source = "email"),
            @Mapping(target = "password", source = "password"),
            @Mapping(target = "faculty", source = "faculty"),
            @Mapping(target = "speciality", source = "speciality"),
            @Mapping(target = "group", source = "group"),
    })
    public User toEntity(UsersTable usersTable);

    @Mappings({
            @Mapping(target = "email", source = "email", expression = "java(user.getEmail().getEmail())"),
            @Mapping(target = "password", source = "password", expression = "java(user.getPassword().getPassword())"),
            @Mapping(target = "faculty", source = "faculty"),
            @Mapping(target = "speciality", source = "speciality"),
            @Mapping(target = "group", source = "group"),
    })
    public UsersTable toUsersTable(User user);

}
