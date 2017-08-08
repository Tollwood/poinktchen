package com.app.controller;


import java.util.List;

import com.app.entity.User;
import com.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController extends BaseController {


    private UserService userService;

    @Autowired
    UserController(UserService userService){
        this.userService = userService;
    }

    @RequestMapping("/api/users")
    public List<User> getAllUser() {
        List<User> result = userService.findAll();
        return result;
    }


    @RequestMapping(value = "/api/users/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public User getUserById(@PathVariable("id") long id) {
        User result = userService.findById(id);
        return result;
    }

}
