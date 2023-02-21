package com.manage.user.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "This username Already exist")
public class UserAlreadyExistException extends RuntimeException{
    /**
     * Constructs a new exception with the specified detail message.
     *
     * @param message the detail message. The detail message is saved for later
     * retrieval by the Copy code {@link #getMessage()} method.
     */
    public UserAlreadyExistException(String message) {
        super(message);
    }
}
