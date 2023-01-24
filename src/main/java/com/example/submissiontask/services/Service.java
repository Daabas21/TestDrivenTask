package com.example.submissiontask.services;

import com.example.submissiontask.Repo.AppUserRepo;
import com.example.submissiontask.entity.AppUser;

import java.util.List;
import java.util.stream.Collectors;

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
        return appUserRepo.findByUsernameAndPassword(appUser).orElseThrow();
    }
}
