package com.manage.user.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN, reason = "User is not a french resident")
public class UserNotFrenchResidentException extends RuntimeException {

    public UserNotFrenchResidentException(String message) {
        super(message);
    }
}
