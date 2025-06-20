package com.example.Project.Collaboaration.API.project.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "createdDate")
    private LocalDate createdDate;

    public Project(Integer id, String description) {
        this.id = id;
        this.description = description;
        this.createdDate = LocalDate.now();
    }

    public Project() {
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
        Project project = (Project) o;
        return Objects.equals(getId(), project.getId()) && Objects.equals(getName(), project.getName()) && Objects.equals(getDescription(), project.getDescription()) && Objects.equals(getCreatedDate(), project.getCreatedDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getDescription(), getCreatedDate());
    }
}
