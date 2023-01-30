package com.lms.user.excption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Incorrect username/password")
public class IncorrectUserCredentialException extends Exception {

    private static final long serialVersionUID = 1L;
}
