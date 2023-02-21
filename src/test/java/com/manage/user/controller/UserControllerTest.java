package com.manage.user.controller;

import com.manage.user.enums.Country;
import com.manage.user.enums.Gender;
import com.manage.user.model.dto.UserDTO;
import com.manage.user.service.IUserService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private IUserService userService;

    @InjectMocks
    private UserController userController;


    /**
     * Create User Unit Test
     * @throws Exception
     */
    @Test
    void createUserIntTest() throws Exception {
        UserDTO userDTO = UserDTO.builder().id(1L).username("karim").birthDate(LocalDate.of(1992, 11, 19)).country(Country.FRANCE.name()).phoneNumber("066698855").gender(Gender.MALE).build();

        when(userService.createUser(any(UserDTO.class))).thenReturn(userDTO);
        UserDTO controllerResponse = userController.createUser(userDTO);

        Assert.assertEquals(controllerResponse.getId(), userDTO.getId());
        Assert.assertEquals(controllerResponse.getUsername(), userDTO.getUsername());

    }

    /**
     * Get User By Id Unit Test
     * @throws Exception
     */
    @Test
    void getUserByIdTest() throws Exception {
        UserDTO userDTO = UserDTO.builder().id(1L).username("karim").birthDate(LocalDate.of(1992, 11, 19)).country(Country.FRANCE.name()).phoneNumber("066698855").gender(Gender.MALE).build();

        when(userService.getUserById(any(Long.class))).thenReturn(userDTO);
        UserDTO controllerResponse = userController.getUserById(1L);

        Assert.assertEquals(controllerResponse.getId(), userDTO.getId());
        Assert.assertEquals(controllerResponse.getUsername(), userDTO.getUsername());
    }
}
