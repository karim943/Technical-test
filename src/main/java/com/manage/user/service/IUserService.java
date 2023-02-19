package com.manage.user.service;

import com.manage.user.exceptions.UserAlreadyExistException;
import com.manage.user.exceptions.UserNotFoundException;
import com.manage.user.model.dto.UserDTO;

import javax.validation.constraints.NotNull;

public interface IUserService {

    UserDTO createUser(@NotNull UserDTO userDto) throws UserAlreadyExistException;


    UserDTO getUserById(String id) throws UserNotFoundException;
}
