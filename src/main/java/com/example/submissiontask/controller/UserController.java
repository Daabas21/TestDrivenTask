package com.example.submissiontask.controller;

import com.example.submissiontask.entity.AppUser;
import com.example.submissiontask.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public AppUser findByUsername(@RequestParam String username){
        return userService.findUserByUsername(username);
    }


}
