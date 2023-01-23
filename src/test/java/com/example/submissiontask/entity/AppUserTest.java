package com.example.submissiontask.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppUserTest {

    @Test
    public void constructor_withProperties_getterMethodShouldReturnProperties(){
        //Given
        AppUser appUser = new AppUser("hassan", "pass");

        //When
        String username = appUser.getUsername();
        String password = appUser.getPassword();

        //Then
        assertAll(
                () -> assertEquals("hassan", username),
                () -> assertEquals("pass", password),
                () -> assertEquals(new AppUser("hassan", "pass"), appUser)
        );
    }

}
