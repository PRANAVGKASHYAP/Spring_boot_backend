package com.example.demo.error;

import com.example.demo.entity.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice // this annotations is needed for exception handlers
@ResponseStatus
public class ExceptionHandler extends ResponseEntityExceptionHandler {
    //methods to handel specific exceptions

    @org.springframework.web.bind.annotation.ExceptionHandler(DepartmentNotFound.class)
    public ResponseEntity<ErrorMessage> departmentNotFound(DepartmentNotFound departmentNotFound , WebRequest webRequest)
    {
        ErrorMessage message = new ErrorMessage(HttpStatus.NOT_FOUND , departmentNotFound.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
    }

}
