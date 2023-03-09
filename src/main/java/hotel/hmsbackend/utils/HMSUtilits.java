package hotel.hmsbackend.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class HMSUtilits {
    public HMSUtilits() {

    }
    public static ResponseEntity<String> getResponseEntity(String responseMessage, HttpStatus httpStatus){
        return new ResponseEntity<String>("{\"messgae\":\""+ responseMessage+"\" }", httpStatus);
    }
}
