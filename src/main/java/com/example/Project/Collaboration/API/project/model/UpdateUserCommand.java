package com.example.Project.Collaboration.API.project.model;

import com.example.Project.Collaboration.API.project.model.user.User;

public class UpdateUserCommand {

    private Integer id;
    private User user;

    public UpdateUserCommand(Integer id, User user) {
        this.id = id;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public User getUser() {
        return user;
    }
}
