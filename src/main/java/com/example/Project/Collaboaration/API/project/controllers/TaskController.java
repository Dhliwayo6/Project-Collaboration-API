package com.example.Project.Collaboaration.API.project.controllers;

import com.example.Project.Collaboaration.API.project.model.UpdateTaskCommand;
import com.example.Project.Collaboaration.API.project.model.task.Task;
import com.example.Project.Collaboaration.API.project.model.task.TaskDTO;
import com.example.Project.Collaboaration.API.project.services.tasks.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {

    private CreateTaskService createTaskService;
    private GetTaskService getTaskService;
    private GetTasksService getTasksService;
    private DeleteTaskService deleteTaskService;
    private UpdateTaskService updateTaskService;


    public TaskController(CreateTaskService createTaskService,
                          GetTaskService getTaskService,
                          GetTasksService getTasksService,
                          DeleteTaskService deleteTaskService,
                          UpdateTaskService updateTaskService) {
        this.createTaskService = createTaskService;
        this.getTaskService = getTaskService;
        this.getTasksService = getTasksService;
        this.deleteTaskService = deleteTaskService;
        this.updateTaskService = updateTaskService;
    }

    @PostMapping("/task")
    public ResponseEntity<TaskDTO> createTask(@RequestBody Task task) {
        return createTaskService.execute(task);
    }

    @GetMapping("/tasks")
    public ResponseEntity<List<TaskDTO>> getTasks() {
        return getTasksService.execute(null);
    }

    @GetMapping("/task{id}")
    public ResponseEntity<TaskDTO> getTaskById(@PathVariable Integer id) {
        return getTaskService.execute(id);
    }

    @PutMapping("/task{id}")
    public ResponseEntity<TaskDTO> updateTask(@PathVariable Integer id, @RequestBody Task task) {
        return updateTaskService.execute(new UpdateTaskCommand(id, task));
    }

    @DeleteMapping("task{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Integer id) {
        return deleteTaskService.execute(id);
    }
}
