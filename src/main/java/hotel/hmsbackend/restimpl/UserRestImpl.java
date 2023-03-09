package hotel.hmsbackend.restimpl;
import hotel.hmsbackend.constent.HMSConstant;
import hotel.hmsbackend.rest.UserRest;
import hotel.hmsbackend.service.UserService;
import hotel.hmsbackend.utils.HMSUtilits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;
@RestController
public class UserRestImpl implements UserRest {
    @Autowired
    private UserService userService;
    @Override
    public ResponseEntity<String> signup(Map<String, String> requestMap) {
        try{
            return userService.signUp(requestMap);


        }catch (Exception ex){
            ex.printStackTrace();

        }
       return HMSUtilits.getResponseEntity(HMSConstant.something_went_wrong,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
