package com.example.submissiontask.services;

import com.example.submissiontask.entity.AppUser;

import java.util.List;
import java.util.stream.Collectors;

public class Service {

    List<AppUser> users = List.of(
            new AppUser("hassan", "pass"),
            new AppUser("pavel","password"),
            new AppUser("viktor", "pass"));

    public boolean login(String username, String password) {

        return users.stream()
                .anyMatch(x -> x.getUsername().equals(username) && x.getPassword().equals(password));
    }
}
