package com.lms.user.excption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Invalid username/password")
public class InvalidUserCredentialException extends  Exception {

    private static final long serialVersionUID = 1L;
}
