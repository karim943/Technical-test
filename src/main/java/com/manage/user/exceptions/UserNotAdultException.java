package com.manage.user.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN, reason = "User is not an adult")
public class UserNotAdultException extends RuntimeException {

    public UserNotAdultException(String message) {
        super(message);
    }
}
