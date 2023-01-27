package com.example.submissiontask.controller;

import com.example.submissiontask.entity.AppUser;
import com.example.submissiontask.services.LoginService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/login")
    public class LoginController {

    private LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping
    public String authenticate(@RequestBody AppUser appUser){
        return loginService.authenticate(appUser.getUsername(), appUser.getPassword());
    }
}
