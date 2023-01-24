package com.example.submissiontask.Repo;

import com.example.submissiontask.entity.AppUser;

import java.util.Optional;

public interface AppUserRepo {


    Optional<AppUser> findByUsernameAndPassword(Object any);
}
