package com.example.Project.Collaboaration.API.project.services;

import com.example.Project.Collaboaration.API.Query;
import com.example.Project.Collaboaration.API.project.ProjectRepository;
import com.example.Project.Collaboaration.API.project.model.Project;
import com.example.Project.Collaboaration.API.project.model.ProjectDTO;
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

        //no need for throwing exception here, just return an empty list
        return ResponseEntity.status(HttpStatus.OK).body(projectDTOS);
    }
}
