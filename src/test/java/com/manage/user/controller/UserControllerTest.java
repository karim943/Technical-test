package com.manage.user.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.manage.user.enums.Gender;
import com.manage.user.model.dto.UserDTO;
import com.manage.user.service.impl.UserServiceImpl;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;


import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {
    @Autowired
    MockMvc mockMvc;


    @MockBean
    private UserServiceImpl userService;

    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void createUserTest() throws Exception {
        UserDTO userDto = UserDTO.builder().id(1L).username("karim").birthDate(LocalDate.of(1992, 11, 19)).country("FRANCE").phoneNumber("066698855").gender(Gender.MALE).build();

        given(userService.createUser(userDto)).willReturn(userDto);

        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        String jsonRequest = objectMapper.writeValueAsString(userDto);

        mockMvc.perform(post("/api/users/create").content(jsonRequest).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", CoreMatchers.is(userDto.getId())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.country",CoreMatchers.is(userDto.getCountry().toString())));
    }


    @Test
    void getUserByIdTest() throws Exception {
        UserDTO userDto = UserDTO.builder().id(1L).username("karim").birthDate(LocalDate.of(1992, 11, 19)).country("MAROC").phoneNumber("066698855").gender(Gender.MALE).build();
        given(userService.getUserById(userDto.getId())).willReturn(userDto);
        mockMvc.perform(get("/api/users/"+userDto.getId())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", CoreMatchers.is(userDto.getId())));
    }
}
