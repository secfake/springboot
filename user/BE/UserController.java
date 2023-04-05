package vn.techmaster.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    User user = new User(1, "admin", "admin@gmail.com", "admin", "./ava.jpg");

    @CrossOrigin
    @RequestMapping("/register")
    public ResponseEntity<?> register() {
        return ResponseEntity.ok(user);
    }


    @CrossOrigin
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> login(@RequestBody User userLogin) {

        if (user.getUsername().equals(userLogin.getUsername()) && user.getPassword().equals(userLogin.getPassword())) {
            return ResponseEntity.ok().body(user);
        } else {
            return ResponseEntity.badRequest().body(new User());
        }
    }
}
