package com.example.Project.Collaboaration.API.project.services.projects;

import com.example.Project.Collaboaration.API.Command;
import com.example.Project.Collaboaration.API.project.model.project.Project;
import com.example.Project.Collaboaration.API.project.model.project.ProjectDTO;
import com.example.Project.Collaboaration.API.project.model.UpdateProjectCommand;
import com.example.Project.Collaboaration.API.project.repositories.ProjectRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateProjectService implements Command<UpdateProjectCommand, ProjectDTO> {

    private ProjectRepository projectRepository;

    public UpdateProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public ResponseEntity<ProjectDTO> execute(UpdateProjectCommand command) {
        Optional<Project> projectOptional = projectRepository.findById(command.getId());

        if (projectOptional.isPresent()) {
            Project project = command.getProject();
            project.setId(command.getId());

            projectRepository.save(project);
            return ResponseEntity.ok(new ProjectDTO(project));
        }

        throw new IllegalArgumentException("Project not found");
    }
}
