package com.example.Project.Collaboaration.API.project.repositories;

import com.example.Project.Collaboaration.API.project.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
