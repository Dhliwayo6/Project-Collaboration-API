package com.example.Project.Collaboaration.API.project.model;

import com.example.Project.Collaboaration.API.project.model.project.Project;

public class UpdateProjectCommand {

    private Integer id;
    private Project project;

    public UpdateProjectCommand(Integer id, Project project) {
        this.id = id;
        this.project = project;
    }

    public Integer getId() {
        return id;
    }

    public Project getProject() {
        return project;
    }
}
