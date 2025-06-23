package com.example.Project.Collaboaration.API.project.services.users;

import com.example.Project.Collaboaration.API.Command;
import com.example.Project.Collaboaration.API.project.model.UpdateUserCommand;
import com.example.Project.Collaboaration.API.project.model.user.User;
import com.example.Project.Collaboaration.API.project.model.user.UserDTO;
import com.example.Project.Collaboaration.API.project.repositories.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateUserService implements Command<UpdateUserCommand, UserDTO> {

    private UserRepository userRepository;

    public UpdateUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public ResponseEntity<UserDTO> execute(UpdateUserCommand command) {

        Optional<User> userOptional = userRepository.findById(command.getId());

        if (userOptional.isPresent()) {
            User user = command.getUser();
            user.setId(command.getId());

            userRepository.save(user);
            return ResponseEntity.ok(new UserDTO(user));
        }

        throw new IllegalArgumentException("User not found");
    }
}
