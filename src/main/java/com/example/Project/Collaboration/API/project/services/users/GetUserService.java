package com.example.Project.Collaboration.API.project.services.users;

import com.example.Project.Collaboration.API.Query;
import com.example.Project.Collaboration.API.project.exceptions.UserNotFoundException;
import com.example.Project.Collaboration.API.project.model.user.User;
import com.example.Project.Collaboration.API.project.model.user.UserDTO;
import com.example.Project.Collaboration.API.project.repositories.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetUserService implements Query<Integer, UserDTO> {

    private UserRepository userRepository;

    public GetUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public ResponseEntity<UserDTO> execute(Integer id) {
        Optional<User> userOptional = userRepository.findById(id);

        if (userOptional.isPresent()) {
            return ResponseEntity.ok(new UserDTO(userOptional.get()));
        }

        throw new UserNotFoundException();
    }
}
