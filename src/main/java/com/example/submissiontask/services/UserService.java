package com.example.submissiontask.services;

import com.example.submissiontask.Repo.AppUserRepo;

public class UserService {

    private AppUserRepo appUserRepo;

    public UserService(AppUserRepo appUserRepo){
        this.appUserRepo = appUserRepo;
    }


    public Object findUserByUsernameAndPassword(String username, String pass) {
        return null;
    }
}
