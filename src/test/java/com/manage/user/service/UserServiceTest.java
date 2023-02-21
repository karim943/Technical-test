package com.manage.user.service;


import com.manage.user.enums.Country;
import com.manage.user.enums.Gender;
import com.manage.user.exceptions.UserNotFoundException;
import com.manage.user.mapper.UserMapper;
import com.manage.user.model.dto.UserDTO;
import com.manage.user.model.entity.User;
import com.manage.user.repository.UserRepository;
import com.manage.user.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@SpringBootTest
class UserServiceTest {

    @Mock
    private UserRepository userRepository;
    @Mock
    private UserMapper userMapper;
    @InjectMocks
    private UserServiceImpl userService;

    /**
     * Create User Unit Test
     * @throws Exception
     */
    @Test
    void createUserTest() throws Exception{
        UserDTO userDto = UserDTO.builder().id(1L).username("karim").birthDate(LocalDate.of(1992, 11, 19)).country("France").phoneNumber("066698855").gender(Gender.MALE).build();
        User user = User.builder().id(1L).username("karim").birthDate(LocalDate.of(1992, 11, 19)).country("France").phoneNumber("066698855").gender(Gender.MALE).build();

        when(userRepository.save(any(User.class))).thenReturn(user);
        when(userMapper.userDtoToUser(userDto)).thenReturn(user);
        when(userMapper.userToUserDto(user)).thenReturn(userDto);

        UserDTO serviceResponse = userService.createUser(userDto);

        Assertions.assertEquals(serviceResponse.getId(), userDto.getId());
        Assertions.assertEquals(serviceResponse.getUsername(), userDto.getUsername());
        Assertions.assertEquals(serviceResponse.getGender(), userDto.getGender());
    }

    /**
     * Get User By Id Unit Test
     * @throws UserNotFoundException
     */
    @Test
    void getUserByIdTest() throws UserNotFoundException{
        UserDTO userDto = UserDTO.builder().id(1L).username("karim").birthDate(LocalDate.of(1992, 11, 19)).country(Country.FRANCE.name()).phoneNumber("066698855").gender(Gender.MALE).build();
        User user = User.builder().id(1L).username("karim").birthDate(LocalDate.of(1992, 11, 19)).country("France").phoneNumber("066698855").gender(Gender.MALE).build();

        when(userRepository.findById(userDto.getId())).thenReturn(Optional.ofNullable(user));
        when(userMapper.userToUserDto(user)).thenReturn(userDto);

        UserDTO serviceResponse = userService.getUserById(1L);

        Assertions.assertEquals(serviceResponse.getId(), userDto.getId());
        Assertions.assertEquals(serviceResponse.getUsername(), userDto.getUsername());
        Assertions.assertEquals(serviceResponse.getGender(), userDto.getGender());
    }
}
