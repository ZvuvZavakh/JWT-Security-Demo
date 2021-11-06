package zvuv.zavakh.jwtsecuritydemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import zvuv.zavakh.jwtsecuritydemo.domain.User;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    @Query("select u from User u join fetch u.roles where u.email = ?1")
    Optional<User> getUserByEmail(String email);
}
