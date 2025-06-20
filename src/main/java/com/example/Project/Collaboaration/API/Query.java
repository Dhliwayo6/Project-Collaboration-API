package com.example.Project.Collaboaration.API;

import org.springframework.http.ResponseEntity;

public interface Query <I, O>{
    ResponseEntity<O> execute(I input);
}
