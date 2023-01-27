package com.example.submissiontask.services;

import com.example.submissiontask.Repo.AppUserRepo;
import com.example.submissiontask.entity.AppUser;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private JwtUtils jwtUtils;
    private AppUserRepo appUserRepo;

    public LoginService(){

    }

    public LoginService(AppUserRepo appUserRepo){
        this.appUserRepo = appUserRepo;
    }

    public LoginService(JwtUtils jwtUtils, AppUserRepo appUserRepo) {
        this.jwtUtils = jwtUtils;
        this.appUserRepo = appUserRepo;
    }

    public String authenticate(String username, String password){

        if (appUserRepo.findByUsernameAndPassword(username, password).isPresent()){
            return jwtUtils.generateToken(username);
        } else{
            return "username or password incorrect";
        }
    }
}
