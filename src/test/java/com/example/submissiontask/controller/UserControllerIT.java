package com.example.submissiontask.controller;

import com.example.submissiontask.entity.AppUser;
import com.example.submissiontask.services.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerIT {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    UserService userService;

    @Test
    public void findUser_withQueryParam_shouldReturnUser() throws Exception {
        //Given
        String username = "hassan";
        long id = 1;
        AppUser appUser = new AppUser(id, username);
        when(userService.findUserByUsername(username)).thenReturn(appUser);

        //When, Then
        mockMvc
                .perform(MockMvcRequestBuilders.get("/api/user?username="+ username))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(id))
                .andDo(print());

        verify(userService, times(1)).findUserByUsername(username);
    }
}
