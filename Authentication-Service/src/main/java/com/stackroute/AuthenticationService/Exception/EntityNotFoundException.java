package com.stackroute.AuthenticationService.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;





@ResponseStatus(code= HttpStatus.NOT_FOUND , reason = "There is no User with requested EmailId")

public class EntityNotFoundException extends Exception {
}

