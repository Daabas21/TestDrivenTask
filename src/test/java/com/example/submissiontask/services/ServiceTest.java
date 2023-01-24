package com.example.submissiontask.services;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ServiceTest {

    @ParameterizedTest
    @CsvSource(value = {"hassan, pass", "pavel, password", "viktor, pas"})
    public void checkUsernamePasswordLoginAuthorization(String username, String password){
        //Given
        Service service = new Service();

        //When
        boolean isLogged = service.login(username, password);

        //Then
        assertTrue(isLogged);
    }

}
