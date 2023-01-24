package com.example.submissiontask.services;

import com.example.submissiontask.Repo.AppUserRepo;
import com.example.submissiontask.entity.AppUser;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ServiceTest {

    @Mock
    AppUserRepo appUserRepo;

    @ParameterizedTest
    @CsvSource(value = {"hassan, pass", "pavel, password", "viktor, pass"})
    public void checkUsernamePasswordLoginAuthorization(String username, String password){
        //Given
        Service service = new Service();

        //When
        boolean isLogged = service.login(username, password);

        //Then
        assertTrue(isLogged);
    }

    @Test
    public void findByUsernameAndPassword_ifExist_returnTrue(){
        //Given
        AppUser alex = new AppUser("Alex", "s");
        when(appUserRepo.findByUsernameAndPassword(any())).thenReturn(Optional.of(new AppUser("Alex", "pass")));
        Service service = new Service(appUserRepo);

        //When
        AppUser appUser = service.findByUsernameAndPassword(alex);

        //Then
        verify(appUserRepo, times(1)).findByUsernameAndPassword(appUser);
    }

}
