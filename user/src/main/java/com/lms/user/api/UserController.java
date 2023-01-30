package com.lms.user.api;


import com.lms.user.entity.User;
import com.lms.user.excption.UserAlreadyExistsException;
import com.lms.user.excption.UserNotFoundException;
import com.lms.user.service.UserService;
import com.lms.user.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("getuserbyid/{id}")
    private ResponseEntity<?> getUserByid(@PathVariable String id) throws UserNotFoundException {

        return  new ResponseEntity<User>(userService.getUserById(id), HttpStatus.OK);

    }
    @PostMapping
    private ResponseEntity<?> register(@RequestBody User user) throws UserAlreadyExistsException {

        return  new ResponseEntity<User>(userService.registerUser(user), HttpStatus.OK);

    }



}
