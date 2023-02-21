package com.manage.user.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN, reason = "User is not an adult")
public class UserNotAdultException extends RuntimeException {
    /**
     * Creates a new UserNotAdultException with the specified message.
     *
     * @param message the message to include in the exception
     */
    public UserNotAdultException(String message) {
        super(message);
    }
}
