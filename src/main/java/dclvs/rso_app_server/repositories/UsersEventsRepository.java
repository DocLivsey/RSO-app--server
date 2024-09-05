package dclvs.rso_app_server.repositories;

import dclvs.rso_app_server.enteties.UsersEventsTable;
import dclvs.rso_app_server.enteties.UsersTable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersEventsRepository extends JpaRepository<UsersEventsTable, Long> {



}
