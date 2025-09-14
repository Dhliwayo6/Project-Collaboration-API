package com.example.Project.Collaboration.API.project.model;

import com.example.Project.Collaboration.API.project.model.task.Task;

public class UpdateTaskCommand {

    private Integer id;
    private Task task;

    public UpdateTaskCommand(Integer id, Task task) {
        this.id = id;
        this.task = task;
    }

    public Integer getId() {
        return id;
    }

    public Task getTask() {
        return task;
    }
}
