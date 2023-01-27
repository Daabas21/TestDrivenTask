package com.example.submissiontask.services;

import com.example.submissiontask.LoginException;
import com.example.submissiontask.Repo.AppUserRepo;
import com.example.submissiontask.entity.AppUser;

import java.util.List;

public class Service {

    AppUserRepo appUserRepo;

    public Service(){

    }

    public Service(AppUserRepo appUserRepo) {
        this.appUserRepo = appUserRepo;
    }

    List<AppUser> users = List.of(
            new AppUser("hassan", "pass"),
            new AppUser("pavel","password"),
            new AppUser("viktor", "pass"));


    public boolean login(String username, String password) {

        return users.stream()
                .anyMatch(x -> x.getUsername().equals(username) && x.getPassword().equals(password));
    }

    public AppUser findByUsernameAndPassword(AppUser appUser) {
        if (appUserRepo.findByUsernameAndPassword(appUser.getUsername(), appUser.getPassword()).isEmpty()){
            throw new LoginException();
        }
        return appUserRepo.findByUsernameAndPassword(appUser.getUsername(), appUser.getPassword()).orElseThrow();
    }
}
