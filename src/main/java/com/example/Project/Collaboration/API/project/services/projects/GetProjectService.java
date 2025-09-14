package com.example.Project.Collaboration.API.project.services.projects;

import com.example.Project.Collaboration.API.Query;
import com.example.Project.Collaboration.API.project.exceptions.ProjectNotFoundException;
import com.example.Project.Collaboration.API.project.model.project.Project;
import com.example.Project.Collaboration.API.project.model.project.ProjectDTO;
import com.example.Project.Collaboration.API.project.repositories.ProjectRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetProjectService implements Query<Integer, ProjectDTO> {

    private ProjectRepository projectRepository;

    public GetProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public ResponseEntity<ProjectDTO> execute(Integer input) {

        Optional<Project> projectOptional = projectRepository.findById(input);

        if (projectOptional.isPresent()) {
            return ResponseEntity.ok(new ProjectDTO(projectOptional.get()));
        }

        throw new ProjectNotFoundException();
    }
}
