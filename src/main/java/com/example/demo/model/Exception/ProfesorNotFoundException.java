package com.example.demo.model.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ProfesorNotFoundException extends RuntimeException{

    public ProfesorNotFoundException(Long id) {
        super(String.format("Manufacturer with id: %d was not found", id));
    }
}
