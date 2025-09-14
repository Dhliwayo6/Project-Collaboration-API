package com.example.Project.Collaboration.API.project.services.projects;

import com.example.Project.Collaboration.API.Command;
import com.example.Project.Collaboration.API.project.exceptions.ProjectNotFoundException;
import com.example.Project.Collaboration.API.project.model.project.Project;
import com.example.Project.Collaboration.API.project.repositories.ProjectRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeleteProjectService implements Command<Integer, Void> {

    private ProjectRepository projectRepository;

    public DeleteProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public ResponseEntity<Void> execute(Integer id) {

        Optional<Project> projectOptional = projectRepository.findById(id);

        if (projectOptional.isPresent()) {
            projectRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        throw new ProjectNotFoundException();
    }
}
