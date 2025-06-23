package com.example.Project.Collaboaration.API.project.services.tasks;

import com.example.Project.Collaboaration.API.Query;
import com.example.Project.Collaboaration.API.project.model.task.Task;
import com.example.Project.Collaboaration.API.project.model.task.TaskDTO;
import com.example.Project.Collaboaration.API.project.repositories.TaskRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetTasksService implements Query<Void, List<TaskDTO>> {

    private TaskRepository taskRepository;

    public GetTasksService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public ResponseEntity<List<TaskDTO>> execute(Void input) {
        List<Task> tasks = taskRepository.findAll();
        List<TaskDTO> taskDTOS = tasks.stream().map(TaskDTO::new).toList();

        return ResponseEntity.status(HttpStatus.OK).body(taskDTOS);
    }
}
