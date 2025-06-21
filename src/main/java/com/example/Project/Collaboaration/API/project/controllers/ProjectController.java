package com.example.Project.Collaboaration.API.project.controllers;

import com.example.Project.Collaboaration.API.project.model.Project;
import com.example.Project.Collaboaration.API.project.model.ProjectDTO;
import com.example.Project.Collaboaration.API.project.model.UpdateProjectCommand;
import com.example.Project.Collaboaration.API.project.services.projects.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProjectController {

    private final CreateProjectService createProjectService;
    private final GetProjectsService getProjectsService;
    private final GetProjectService getProjectService;
    private final DeleteProjectService deleteProjectService;
    private final UpdateProjectService updateProjectService;

    public ProjectController(CreateProjectService createProjectService,
                             GetProjectsService getProjectsService,
                             GetProjectService getProjectService,
                             DeleteProjectService deleteProjectService,
                             UpdateProjectService updateProjectService) {
        this.createProjectService = createProjectService;
        this.getProjectsService = getProjectsService;
        this.getProjectService = getProjectService;
        this.deleteProjectService = deleteProjectService;
        this.updateProjectService = updateProjectService;
    }

    @PostMapping("/project")
    public ResponseEntity<ProjectDTO> createProject(@RequestBody Project project){
        return createProjectService.execute(project);
    }

    @GetMapping("projects")
    public ResponseEntity<List<ProjectDTO>> getProducts(){
        return getProjectsService.execute(null);
    }


    @GetMapping("/product/{id}")
    public ResponseEntity<ProjectDTO> getProductById(@PathVariable Integer id) {
        return getProjectService.execute(id);
    }


    @PutMapping("/product/{id}")
    public ResponseEntity<ProjectDTO> updateProduct(@PathVariable Integer id, @RequestBody Project project){
        return updateProjectService.execute(new UpdateProjectCommand(id, project));
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Integer id){
        return deleteProjectService.execute(id);
    }

}

