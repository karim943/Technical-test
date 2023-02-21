package com.manage.user.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN, reason = "User is not a french resident")
public class UserNotFrenchResidentException extends RuntimeException {
    /**
     * Constructs a new exception with the specified detail message.
     *
     * @param message the detail message. The detail message is saved for later
     * retrieval by the Copy code {@link #getMessage()} method.
     */
    public UserNotFrenchResidentException(String message) {
        super(message);
    }
}
