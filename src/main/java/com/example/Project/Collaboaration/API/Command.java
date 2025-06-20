package com.example.Project.Collaboaration.API;

import org.springframework.http.ResponseEntity;

public interface Command <I, O>{
    ResponseEntity<O> execute(I input);
}
