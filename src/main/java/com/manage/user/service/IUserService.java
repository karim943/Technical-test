package com.manage.user.service;

import com.manage.user.exceptions.UserAlreadyExistException;
import com.manage.user.exceptions.UserNotFoundException;
import com.manage.user.model.dto.UserDTO;

import javax.validation.constraints.NotNull;

public interface IUserService {
    /**
     * @param userDto
     * @return UserDTO
     * @throws UserAlreadyExistException
     */
    UserDTO createUser(@NotNull UserDTO userDto) throws UserAlreadyExistException;

    /**
     * @param id
     * @return UserDTO
     * @throws UserNotFoundException
     */
    UserDTO getUserById(Long id) throws UserNotFoundException;
}
