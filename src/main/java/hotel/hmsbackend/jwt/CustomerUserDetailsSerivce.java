package hotel.hmsbackend.jwt;
import hotel.hmsbackend.dao.UserDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.ArrayDeque;
import java.util.Objects;
@Slf4j
@Service
public class CustomerUserDetailsSerivce implements UserDetailsService {
    @Autowired
    UserDao userDao;
    private hotel.hmsbackend.pojo.User userDetail;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("Inside loadUserByUsername {}",username);
        userDetail = userDao.FindByEmailId(username);
        if (!Objects.isNull(userDetail)) {
            return new User(userDetail.getEmail(), userDetail.getPassword(), new ArrayDeque<>());
        } else {
            throw new UsernameNotFoundException("User Not Found.");
        }
    }
    public hotel.hmsbackend.pojo.User getUserDetail() {
//        hotel.hmsbackend.pojo.User user = userDetail;
//        user.setPassword(null);
        return userDetail;
    }
}
