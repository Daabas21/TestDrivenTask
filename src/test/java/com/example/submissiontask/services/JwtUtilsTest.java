package com.example.submissiontask.services;

import com.example.submissiontask.Repo.AppUserRepo;
import com.example.submissiontask.entity.AppUser;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Testcontainers
public class JwtUtilsTest {

    @Container
    private final static PostgreSQLContainer<?> db = new PostgreSQLContainer<>("postgres:11");

    private final static String username = "Sally";
    private final static String password = "pass";

    @DynamicPropertySource
    public static void setProps(DynamicPropertyRegistry registry){
        registry.add("spring.datasource.url", db::getJdbcUrl);
        registry.add("spring.datasource.username", db::getUsername);
        registry.add("spring.datasource.password", db::getPassword);
        registry.add("spring.datasource.driver-class-name", db::getDriverClassName);
        registry.add("spring.jpa.hibernate.ddl-auto", () -> "update");
    }

    @Autowired
    private AppUserRepo appUserRepo;

    @Autowired
    private JwtUtils jwtUtils;


    @BeforeAll
    public static void beforeAll() {
        db.start();
    }

    @Test
    public void save_withUsernameAndPassword_thisUserShouldExist(){
        //Given
        AppUser appUser = new AppUser(1L,username, password);

        //When
        appUserRepo.save(appUser);

        //Then
        assertEquals(1 , appUserRepo.count());
    }

    @Test
    public void loginUser_withCorrectUsernameAndPassword_ShouldReturnToken(){
        //Given
        AppUser appUser = new AppUser(1L, username, password);
        appUserRepo.save(appUser);
        String token = jwtUtils.generateToken(username);
        LoginService loginService = new LoginService(jwtUtils, appUserRepo);

        //When
        String tokenResult = loginService.authenticate(username, password);

        //Then
        assertEquals(token, tokenResult);

    }


}
