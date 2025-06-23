package com.example.Project.Collaboaration.API.project.services.tasks;

import com.example.Project.Collaboaration.API.Command;
import com.example.Project.Collaboaration.API.project.model.task.Task;
import com.example.Project.Collaboaration.API.project.repositories.TaskRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeleteTaskService implements Command<Integer, Void> {

    private TaskRepository taskRepository;

    public DeleteTaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public ResponseEntity<Void> execute(Integer id) {

        Optional<Task> taskOptional = taskRepository.findById(id);

        if (taskOptional.isPresent()) {
            taskRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        throw new IllegalArgumentException("Task not found");

    }
}
