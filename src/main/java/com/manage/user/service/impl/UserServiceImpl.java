package com.manage.user.service.impl;

import com.manage.user.enums.Country;
import com.manage.user.exceptions.UserAlreadyExistException;
import com.manage.user.exceptions.UserNotAdultException;
import com.manage.user.exceptions.UserNotFoundException;
import com.manage.user.exceptions.UserNotFrenchResidentException;
import com.manage.user.mapper.UserMapper;
import com.manage.user.model.dto.UserDTO;
import com.manage.user.model.entity.User;
import com.manage.user.repository.UserRepository;
import com.manage.user.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {

    private UserRepository userRepository;

    private UserMapper userMapper;
    @Override
    public UserDTO createUser(UserDTO userDto) throws UserAlreadyExistException {
        if (userRepository.existsByUsername(userDto.getUsername())) {
            throw new UserAlreadyExistException("Username already exists!");
        }
        if (Objects.isNull(userDto.getCountry()) || !Country.FRANCE.name().equalsIgnoreCase(userDto.getCountry())) {
            throw new UserNotFrenchResidentException("Only french resident are allowed to create an account!");
        }
        if (Period.between(userDto.getBirthDate(), LocalDate.now()).getYears() < 18) {
            throw new UserNotAdultException("Only adult are allowed to create an account!");
        }
        User user = userMapper.userDtoToUser(userDto);
        return userMapper.userToUserDto(userRepository.save(user));
    }

    @Override
    public UserDTO getUserById(String id) throws UserNotFoundException {
        User user = userRepository.findById(id).orElseThrow(()-> new UserNotFoundException("User Not Found!"));
        return userMapper.userToUserDto(user);
    }
}
