package com.example.Project.Collaboaration.API.project.model.task;

import com.example.Project.Collaboaration.API.project.model.project.Project;

import java.time.LocalDate;
import java.util.Objects;

public class TaskDTO {

    private Integer id;
    private String title;
    private String content;
    private LocalDate dateCreated;
    private Project project;

    public TaskDTO(Task task) {
        this.id = task.getId();
        this.title = task.getTitle();
        this.content = task.getContent();
        this.dateCreated = task.getDateCreated();
        this.project = task.getProject();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        TaskDTO taskDTO = (TaskDTO) o;
        return Objects.equals(id, taskDTO.id) && Objects.equals(title, taskDTO.title) && Objects.equals(content, taskDTO.content) && Objects.equals(dateCreated, taskDTO.dateCreated) && Objects.equals(project, taskDTO.project);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, content, dateCreated, project);
    }
}
