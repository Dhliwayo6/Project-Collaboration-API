package com.example.Project.Collaboration.API.project.controllers;

import com.example.Project.Collaboration.API.project.model.UpdateUserCommand;
import com.example.Project.Collaboration.API.project.model.user.User;
import com.example.Project.Collaboration.API.project.model.user.UserDTO;
import com.example.Project.Collaboration.API.project.services.users.*;
import com.example.Project.Collaboration.API.project.services.users.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final CreateUserService createUserService;
    private final GetUserService getUserService;
    private final GetUsersService getUsersService;
    private final UpdateUserService updateUserService;
    private final DeleteUserService deleteUserService;

    public UserController(CreateUserService createUserService,
                          GetUserService getUserService,
                          GetUsersService getUsersService,
                          UpdateUserService updateUserService,
                          DeleteUserService deleteUserService) {
        this.createUserService = createUserService;
        this.getUserService = getUserService;
        this.getUsersService = getUsersService;
        this.updateUserService = updateUserService;
        this.deleteUserService = deleteUserService;
    }

    @PostMapping("/user")
    public ResponseEntity<UserDTO> createUser(@RequestBody User user) {
        return createUserService.execute(user);
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserDTO>> getUsers() {
        return getUsersService.execute(null);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Integer id) {
        return getUserService.execute(id);
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable Integer id, @RequestBody User user) {
        return updateUserService.execute(new UpdateUserCommand(id, user));
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer id) {
        return deleteUserService.execute(id);
    }
}
