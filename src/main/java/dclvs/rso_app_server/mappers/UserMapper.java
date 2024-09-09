package dclvs.rso_app_server.mappers;

import dclvs.rso_app_server.enteties.User;
import dclvs.rso_app_server.enteties.UsersTable;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {

    public User toEntity(UsersTable usersTable);

    public UsersTable toUsersTable(User user);

}
