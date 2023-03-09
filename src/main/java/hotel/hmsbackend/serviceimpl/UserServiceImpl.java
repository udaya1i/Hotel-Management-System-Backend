package hotel.hmsbackend.serviceimpl;
import hotel.hmsbackend.constent.HMSConstant;
import hotel.hmsbackend.dao.UserDao;
import hotel.hmsbackend.pojo.User;
import hotel.hmsbackend.service.UserService;
import hotel.hmsbackend.utils.HMSUtilits;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.Objects;
@Slf4j
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;
    @Override
    public ResponseEntity<String> signUp(Map<String, String> requestMap) {
        log.info("Inside Signup{}", requestMap);
        try {
            if (validateSignUpMap(requestMap)) {
                User user = userDao.FindByEmailId(requestMap.get("email"));
                if (Objects.isNull(user)) {
                    userDao.save(getUserFromMap(requestMap));
                    return HMSUtilits.getResponseEntity("Register Successfully", HttpStatus.OK);
                } else {
                    return HMSUtilits.getResponseEntity("User is Already Registered with Same Email Address", HttpStatus.BAD_REQUEST);
                }
            } else {
                return HMSUtilits.getResponseEntity(HMSConstant.invalid_data, HttpStatus.BAD_REQUEST);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return HMSUtilits.getResponseEntity(HMSConstant.something_went_wrong, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    private boolean validateSignUpMap(Map<String, String> requestMap){
       if(requestMap.containsKey("name")&& requestMap.containsKey("contactNumber")
                && requestMap.containsKey("email")&& requestMap.containsKey("password"))
       {
           return true;
        }
       return false;
    }
    private User getUserFromMap(Map<String, String> requestMap){
        User user = new User();
        user.setName(requestMap.get("name"));
        user.setContactNumber(requestMap.get("contactNumber"));
        user.setEmail(requestMap.get("email"));
        user.setPassword(requestMap.get("password"));
        user.setStatus("false");
        user.setRole("user");
        return user;
    }
}
