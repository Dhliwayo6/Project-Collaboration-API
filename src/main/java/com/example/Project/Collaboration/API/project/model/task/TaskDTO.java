package com.example.Project.Collaboration.API.project.model.task;

import java.util.Objects;

public class TaskDTO {

    private Integer id;
    private String title;
    private String content;
    private Integer projectId;

    public TaskDTO(Task task) {
        this.id = task.getId();
        this.title = task.getTitle();
        this.content = task.getContent();
        this.projectId = task.getProject().getId();
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

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        TaskDTO taskDTO = (TaskDTO) o;
        return Objects.equals(id, taskDTO.id) && Objects.equals(title, taskDTO.title) && Objects.equals(content, taskDTO.content) && Objects.equals(projectId, taskDTO.projectId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, content, projectId);
    }
}
