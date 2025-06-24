package com.example.Project.Collaboaration.API.project.model.user;

import com.example.Project.Collaboaration.API.project.model.project.Project;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "app_users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "date_created")
    private LocalDate dateCreated;

    @OneToMany(mappedBy = "user",
                fetch = FetchType.LAZY,
                orphanRemoval = true,
                cascade = CascadeType.ALL)

    private List<Project> projects;

    public User(Integer id, String firstName, String lastName, String email, LocalDate dateCreated) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dateCreated = dateCreated;
        this.projects = new ArrayList<>();
    }

    public User() {
        this.dateCreated = LocalDate.now();
    }

    public  void addProject(Project project) {
        projects.add(project);
        project.setUser(this);
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && Objects.equals(email, user.email) && Objects.equals(dateCreated, user.dateCreated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email, dateCreated);
    }
}


