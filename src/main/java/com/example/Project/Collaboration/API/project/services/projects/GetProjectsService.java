package com.example.Project.Collaboration.API.project.services.projects;

import com.example.Project.Collaboration.API.Query;
import com.example.Project.Collaboration.API.project.repositories.ProjectRepository;
import com.example.Project.Collaboration.API.project.model.project.Project;
import com.example.Project.Collaboration.API.project.model.project.ProjectDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetProjectsService implements Query<Void, List<ProjectDTO>> {

    private ProjectRepository projectRepository;

    public GetProjectsService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public ResponseEntity<List<ProjectDTO>> execute(Void input) {
        List<Project> projects = projectRepository.findAll();
        List<ProjectDTO> projectDTOS = projects.stream().map(ProjectDTO::new).toList();

        return ResponseEntity.status(HttpStatus.OK).body(projectDTOS);
    }
}
