package com.example.Project.Collaboaration.API.project.repositories;

import com.example.Project.Collaboaration.API.project.model.project.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {
    List<Project> findByUserId(Integer userId);
}

