package com.example.Project.Collaboaration.API.project.model;

import java.time.LocalDate;
import java.util.Objects;

public class ProjectDTO {

    private Integer id;
    private String name;
    private String description;
    private LocalDate createdDate;

    public ProjectDTO(Project project) {
        this.id = project.getId();
        this.name = project.getName();
        this.description = project.getDescription();
        this.createdDate = project.getCreatedDate();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ProjectDTO that = (ProjectDTO) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getName(), that.getName()) && Objects.equals(getDescription(), that.getDescription()) && Objects.equals(getCreatedDate(), that.getCreatedDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getDescription(), getCreatedDate());
    }
}
