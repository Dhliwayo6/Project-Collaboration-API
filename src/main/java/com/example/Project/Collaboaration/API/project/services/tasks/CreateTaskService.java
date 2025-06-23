package com.example.Project.Collaboaration.API.project.services.tasks;

import com.example.Project.Collaboaration.API.Command;
import com.example.Project.Collaboaration.API.project.model.task.TaskDTO;
import com.example.Project.Collaboaration.API.project.model.task.Task;
import com.example.Project.Collaboaration.API.project.repositories.TaskRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CreateTaskService implements Command<Task, TaskDTO> {

    private TaskRepository taskRepository;

    public CreateTaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public ResponseEntity<TaskDTO> execute(Task task) {
         Task taskSaved = taskRepository.save(task);
         return ResponseEntity.status(HttpStatus.CREATED).body(new TaskDTO(taskSaved));
    }
}
