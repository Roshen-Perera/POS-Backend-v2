package lk.ijse.posbackendv2.dao;

import lk.ijse.posbackendv2.entity.impl.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserDAO extends JpaRepository<User, String> {
    Optional<User> findByUserName(String userName);
}
