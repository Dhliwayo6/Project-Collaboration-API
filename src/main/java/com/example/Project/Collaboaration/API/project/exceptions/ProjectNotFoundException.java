package com.example.Project.Collaboaration.API.project.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProjectNotFoundException extends RuntimeException{

    public ProjectNotFoundException() {
        super(ErrorMessages.PROJECT_NOT_FOUND.getMessage());
    }
}
