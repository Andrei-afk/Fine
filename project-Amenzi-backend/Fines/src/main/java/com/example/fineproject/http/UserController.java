package com.example.fineproject.http;

import com.example.fineproject.mongo.document.User;
import com.example.fineproject.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.AccountNotFoundException;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/users")
public class UserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("")
    public HttpStatus addUser(@RequestBody User user) {
        LOGGER.info(String.format("Received adding request for user %s", user.getUsername()));
        try {
            userRepository.createUser(user);
            return HttpStatus.OK;
        } catch (IllegalArgumentException e) {
            return HttpStatus.CONFLICT;
        }
    }

    @GetMapping("")
    public ResponseEntity<?> getUserByUsername(@RequestParam String username, @RequestParam String password,
                                               @RequestParam String personalNumericCode) {
        User user;
        LOGGER.info(String.format("Getting user with following username %s", username));
        try {
            user = userRepository.findByUsernameAndPassword(username, password, personalNumericCode);
            return ResponseEntity.ok(user);
        } catch (AccountNotFoundException e) {
            LOGGER.error(String.format("User %s does not exist!", username));
            return new ResponseEntity<>("NOT_FOUND",HttpStatus.NOT_FOUND);
        }
    }
}
