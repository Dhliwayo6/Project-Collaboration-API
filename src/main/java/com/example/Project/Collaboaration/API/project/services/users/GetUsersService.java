package com.example.Project.Collaboaration.API.project.services.users;

import com.example.Project.Collaboaration.API.Query;
import com.example.Project.Collaboaration.API.project.model.user.User;
import com.example.Project.Collaboaration.API.project.model.user.UserDTO;
import com.example.Project.Collaboaration.API.project.repositories.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetUsersService implements Query<Void, List<UserDTO>> {

    private UserRepository userRepository;

    public GetUsersService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public ResponseEntity<List<UserDTO>> execute(Void input) {

        List<User> users = userRepository.findAll();
        List<UserDTO> userDTOS = users.stream().map(UserDTO::new).toList();

        return ResponseEntity.status(HttpStatus.OK).body(userDTOS);
    }
}
