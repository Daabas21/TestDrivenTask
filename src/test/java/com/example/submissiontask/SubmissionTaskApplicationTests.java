package com.example.submissiontask;

import com.example.submissiontask.Repo.AppUserRepo;
import com.example.submissiontask.entity.AppUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
class SubmissionTaskApplicationTests {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    AppUserRepo appUserRepo;

    @Test
    void contextLoads() {
    }

    @Test
    public void findUser_withQueryParam_shouldReturnUser() throws Exception {
        //Given
        String username = "hassan";
        long id = 1;
        AppUser appUser = new AppUser(id, username);
        appUserRepo.save(appUser);

        //When, Then
        mockMvc
                .perform(MockMvcRequestBuilders.get("/api/user?username="+ username))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.username").value(username))
                .andDo(print());

    }

}
