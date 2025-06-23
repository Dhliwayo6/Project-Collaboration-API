package com.example.Project.Collaboaration.API.project.services.users;

import com.example.Project.Collaboaration.API.Command;
import com.example.Project.Collaboaration.API.project.model.user.User;
import com.example.Project.Collaboaration.API.project.model.user.UserDTO;
import com.example.Project.Collaboaration.API.project.repositories.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CreateUserService implements Command<User, UserDTO> {

    private UserRepository userRepository;

    @Override
    public ResponseEntity<UserDTO> execute(User user) {
        User userSaved = userRepository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(new UserDTO(user));
    }
}
