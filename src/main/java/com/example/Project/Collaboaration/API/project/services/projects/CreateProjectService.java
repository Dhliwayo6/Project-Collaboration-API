package com.example.Project.Collaboaration.API.project.services.projects;

import com.example.Project.Collaboaration.API.Command;
import com.example.Project.Collaboaration.API.project.repositories.ProjectRepository;
import com.example.Project.Collaboaration.API.project.model.Project;
import com.example.Project.Collaboaration.API.project.model.ProjectDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CreateProjectService implements Command<Project, ProjectDTO> {

    private ProjectRepository projectRepository;

    public CreateProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public ResponseEntity<ProjectDTO> execute(Project project) {
        Project productSaved = projectRepository.save(project);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ProjectDTO(productSaved));
    }
}
