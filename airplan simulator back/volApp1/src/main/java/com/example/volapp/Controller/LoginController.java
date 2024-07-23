package com.example.volapp.Controller;

import com.example.volapp.Entity.User;
import com.example.volapp.Repository.UserDao;
import com.example.volapp.Service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
@CrossOrigin("http://localhost:3000/")
public class LoginController {
    private final UserService userServices ;

    public LoginController( UserService userServices) {
        this.userServices = userServices;
    }

    @PostMapping("/user")
    public ResponseEntity<String> isUserValid(@RequestBody User user) {
        User userx=userServices.getUser(user);
        boolean isValid = validateCredentials(userx);
        if (isValid) {
            return new ResponseEntity<>("Login successful", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Invalid credentials", HttpStatus.OK);
        }
    }
    private boolean validateCredentials(User user) {
        return user != null;
    }
}
