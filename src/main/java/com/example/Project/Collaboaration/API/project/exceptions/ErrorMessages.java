package com.example.Project.Collaboaration.API.project.exceptions;


public enum ErrorMessages {
    USER_NOT_FOUND("User Not Found"),
    TASK_NOT_FOUND("Task Not Found"),
    PROJECT_NOT_FOUND("Project Not Found"),
    NAME_REQUIRED("Name is required");

    private String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

