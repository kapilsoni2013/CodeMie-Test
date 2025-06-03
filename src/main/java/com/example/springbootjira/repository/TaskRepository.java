package com.example.springbootjira.repository;

import com.example.springbootjira.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
