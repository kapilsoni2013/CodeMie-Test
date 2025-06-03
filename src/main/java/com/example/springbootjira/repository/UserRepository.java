package com.example.springbootjira.repository;

import com.example.springbootjira.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
