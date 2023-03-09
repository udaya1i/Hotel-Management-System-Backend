package hotel.hmsbackend.dao;

import hotel.hmsbackend.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface UserDao extends JpaRepository<User, Integer> {
    User FindByEmailId(@Param("email")String email);
}
