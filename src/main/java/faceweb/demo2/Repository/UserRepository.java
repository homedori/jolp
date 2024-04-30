package faceweb.demo2.Repository;

import faceweb.demo2.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // <객체 type, pk type>
public interface UserRepository extends JpaRepository<UserEntity, String> {

    boolean existsByUsername(String username);
}