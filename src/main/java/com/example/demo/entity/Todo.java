package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = Todo.TABLE_NAME)
@Data
public class Todo {
    
    public static final String TABLE_NAME = "todos";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_TITLE = "title";
    public static final String COLUMN_DESCRIPTION = "description";
    public static final String COLUMN_COMPLETED = "completed";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = COLUMN_ID)
    private Long id;

    @Column(name = COLUMN_TITLE, nullable = false)
    private String title;

    @Column(name = COLUMN_DESCRIPTION, nullable = false)
    private String description;

    @Column(name = COLUMN_COMPLETED, nullable = false)
    private boolean completed;
}