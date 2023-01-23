package com.example.submissiontask.entity;

import java.util.Objects;

public class AppUser {

    private String username;
    private String password;

    public AppUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppUser appUser = (AppUser) o;
        return Objects.equals(username, appUser.username) && Objects.equals(password, appUser.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password);
    }
}
