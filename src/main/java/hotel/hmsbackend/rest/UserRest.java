package hotel.hmsbackend.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@RequestMapping("/hms")
public interface UserRest {
        @PostMapping("/signup")
        public ResponseEntity<String> signup(@RequestBody (required = true)Map<String, String> requestMap);
}

