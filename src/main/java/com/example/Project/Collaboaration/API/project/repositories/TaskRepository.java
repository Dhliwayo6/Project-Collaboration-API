package com.example.Project.Collaboaration.API.project.repositories;

import com.example.Project.Collaboaration.API.project.model.task.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Integer> {
}
