package com.example.submissiontask.services;

import com.example.submissiontask.Repo.AppUserRepo;
import com.example.submissiontask.entity.AppUser;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private AppUserRepo appUserRepo;

    public UserService(AppUserRepo appUserRepo){
        this.appUserRepo = appUserRepo;
    }


    public AppUser findUserByUsername(String username) {
        return appUserRepo.findByUsername(username).orElseThrow();
    }
}
