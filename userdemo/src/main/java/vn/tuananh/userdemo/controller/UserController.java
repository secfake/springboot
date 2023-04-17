package vn.tuananh.userdemo.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import vn.tuananh.userdemo.entity.User;
import vn.tuananh.userdemo.exception.NotFoundUser;
import vn.tuananh.userdemo.request.CreateUser;
import vn.tuananh.userdemo.request.UpdateUser;
import vn.tuananh.userdemo.service.UserService;
import vn.tuananh.userdemo.service.UserServiceImpl;


@RestController
@RequestMapping("/api/v1")
public class UserController {
    @Autowired
    public UserService userService;

    @GetMapping("/users")
    public ResponseEntity<?> getListUser() {
        return ResponseEntity.ok().body(userService.getListUser());
    }



    @GetMapping("/search")
    public ResponseEntity<?> search(@RequestParam String name) {
        return ResponseEntity.ok().body(userService.search(name));
    }
    @GetMapping("/users/{id}")
    public ResponseEntity<?> getListUser(@PathVariable int id) {
        if (userService.getUser(id) == null) {

        }
        return ResponseEntity.ok().body(userService.getUser(id));
    }
    @PostMapping("/users")
    public ResponseEntity<?> createUser( @RequestBody CreateUser createUser) {
        return ResponseEntity.ok(userService.createUser(createUser));
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<?> updateUser(@Valid @RequestBody UpdateUser user, @PathVariable int id) {
        return ResponseEntity.ok(userService.updatUser(user, id));
    }
    @DeleteMapping("/users/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
        return ResponseEntity.ok("Delete seccuss");
    }
}
