package com.example.Project.Collaboration.API.project.services.tasks;

import com.example.Project.Collaboration.API.Query;
import com.example.Project.Collaboration.API.project.exceptions.TaskNotFoundException;
import com.example.Project.Collaboration.API.project.model.task.Task;
import com.example.Project.Collaboration.API.project.model.task.TaskDTO;
import com.example.Project.Collaboration.API.project.repositories.TaskRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetTaskService implements Query<Integer, TaskDTO> {

    private TaskRepository taskRepository;

    public GetTaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public ResponseEntity<TaskDTO> execute(Integer id) {
        Optional<Task> taskOptional = taskRepository.findById(id);

        if (taskOptional.isPresent()) {
            return ResponseEntity.ok(new TaskDTO(taskOptional.get()));
        }

        throw new TaskNotFoundException();

    }
}
