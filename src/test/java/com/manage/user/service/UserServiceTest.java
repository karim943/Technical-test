package com.manage.user.service;

import com.manage.user.enums.Gender;
import com.manage.user.exceptions.UserNotFoundException;
import com.manage.user.mapper.UserMapper;
import com.manage.user.model.dto.UserDTO;
import com.manage.user.model.entity.User;
import com.manage.user.repository.UserRepository;
import com.manage.user.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    UserRepository userRepository;

    /**
     * User Mapper
     */
    @Mock
    UserMapper userMapper;

    /**
     * User Service
     */
    @InjectMocks
    UserServiceImpl userService;

    @Test
    void createUserTest() {
        User user = User.builder().id(1L).username("karim").birthDate(LocalDate.of(1992, 11, 19)).country("FRANCE").phoneNumber("0612345678").gender(Gender.MALE).build();
        UserDTO userDto = UserDTO.builder().id(1L).username("karim").birthDate(LocalDate.of(1992, 11, 19)).country("FRANCE").phoneNumber("0612345678").gender(Gender.MALE).build();

        Mockito.when(userRepository.save(ArgumentMatchers.any(User.class))).thenReturn(user);
        Mockito.when(userMapper.userDtoToUser(ArgumentMatchers.any(UserDTO.class))).thenReturn(user);
        Mockito.when(userMapper.userToUserDto(ArgumentMatchers.any(User.class))).thenReturn(userDto);

        UserDTO createdUserDto = userService.createUser(userDto);

        assertThat(createdUserDto.getId()).isSameAs(userDto.getId());
        assertThat(createdUserDto.getCountry()).isSameAs(userDto.getCountry());
        Mockito.verify(userRepository).save(user);
    }


    @Test
    void getUserByIdTest() throws UserNotFoundException {
        User user = User.builder().id(1L).username("karim").birthDate(LocalDate.of(1992, 11, 19)).country("FRANCE").phoneNumber("0612345678").gender(Gender.MALE).build();
        UserDTO userDto = UserDTO.builder().id(1L).username("karim").birthDate(LocalDate.of(1992, 11, 19)).country("FRANCE").phoneNumber("0612345678").gender(Gender.MALE).build();

        Mockito.when(userRepository.findById(user.getId())).thenReturn(Optional.of(user));
        Mockito.when(userMapper.userToUserDto(ArgumentMatchers.any(User.class))).thenReturn(userDto);

        UserDTO expectedUser = userService.getUserById(user.getId());

        assertThat(expectedUser).isSameAs(userDto);
        Mockito.verify(userRepository).findById(user.getId());
    }
}
