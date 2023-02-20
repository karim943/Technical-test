package com.manage.user.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.manage.user.enums.Country;
import com.manage.user.enums.Gender;
import com.manage.user.model.dto.UserDTO;
import com.manage.user.service.IUserService;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private IUserService userService;

    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void createUserIntTest() throws Exception {
        UserDTO userDTO = UserDTO.builder().id(1L).username("karim").birthDate(LocalDate.of(1992, 11, 19)).country(Country.FRANCE.name()).phoneNumber("066698855").gender(Gender.MALE).build();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        String jsonRequest = objectMapper.writeValueAsString(userDTO);

        when(userService.createUser(any(UserDTO.class))).thenReturn(userDTO);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/users/create").content(jsonRequest).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", CoreMatchers.is(userDTO.getId()), Long.class))
                .andExpect(MockMvcResultMatchers.jsonPath("$.country", CoreMatchers.is(userDTO.getCountry())));

    }

    @Test
    void getUserByIdTest() throws Exception {
        UserDTO userDTO = UserDTO.builder().id(1L).username("karim").birthDate(LocalDate.of(1992, 11, 19)).country(Country.FRANCE.name()).phoneNumber("066698855").gender(Gender.MALE).build();

        when(userService.getUserById(any(Long.class))).thenReturn(userDTO);
        mockMvc.perform(get("/api/users/" + userDTO.getId())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", CoreMatchers.is(userDTO.getId()), Long.class));
    }
}
