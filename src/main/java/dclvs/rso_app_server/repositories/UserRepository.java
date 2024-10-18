package dclvs.rso_app_server.repositories;

import dclvs.rso_app_server.entities.UsersTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UsersTable, Long> {

    Optional<UsersTable> findByUserId(Long userId);

    @Query("select u from UsersTable u")
    Optional<List<UsersTable>> findAllUsers();

}
