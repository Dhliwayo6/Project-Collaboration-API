package com.example.Project.Collaboaration.API.project.services.tasks;

import com.example.Project.Collaboaration.API.Command;
import com.example.Project.Collaboaration.API.project.exceptions.TaskNotFoundException;
import com.example.Project.Collaboaration.API.project.model.UpdateTaskCommand;
import com.example.Project.Collaboaration.API.project.model.task.Task;
import com.example.Project.Collaboaration.API.project.model.task.TaskDTO;
import com.example.Project.Collaboaration.API.project.repositories.TaskRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateTaskService implements Command<UpdateTaskCommand, TaskDTO> {

    private TaskRepository taskRepository;

    public UpdateTaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public ResponseEntity<TaskDTO> execute(UpdateTaskCommand command) {
        Optional<Task> taskOptional = taskRepository.findById(command.getId());

        if (taskOptional.isPresent()) {
            Task task = command.getTask();
            task.setId(command.getId());

            taskRepository.save(task);
            return ResponseEntity.ok(new TaskDTO(task));
        }

        throw new TaskNotFoundException();
    }
}
