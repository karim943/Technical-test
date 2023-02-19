package com.manage.user.controller;

import com.manage.user.annotations.LogOnTimeExecution;
import com.manage.user.exceptions.UserAlreadyExistException;
import com.manage.user.exceptions.UserNotFoundException;
import com.manage.user.model.dto.UserDTO;
import com.manage.user.service.IUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/users")
@Validated
@Slf4j
@RequiredArgsConstructor
public class UserController {

    private final IUserService userService;

    @PostMapping("/create")
    @ResponseBody
    @ResponseStatus(value = HttpStatus.CREATED)
    @LogOnTimeExecution
    public UserDTO createUser(@RequestBody @Valid UserDTO userDto) throws UserAlreadyExistException {
        return userService.createUser(userDto);
    }

    @GetMapping("/{id}")
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    @LogOnTimeExecution
    public UserDTO getUserById(@PathVariable Long id) throws UserNotFoundException {
        return userService.getUserById(id);

    }
}
