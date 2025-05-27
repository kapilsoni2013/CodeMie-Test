package com.example.todo.controller;

import com.example.todo.model.Todo;
import com.example.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private static final String TOPIC = "todo-topic";

    @GetMapping
    public List<Todo> getAllTodos() {
        kafkaTemplate.send(TOPIC, "Fetch all todos");
        return todoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Todo> getTodoById(@PathVariable Long id) {
        Optional<Todo> todo = todoRepository.findById(id);
        if (todo.isPresent()) {
            kafkaTemplate.send(TOPIC, "Fetch a todo with ID " + id);
            return ResponseEntity.ok(todo.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Todo createTodo(@RequestBody Todo todo) {
        kafkaTemplate.send(TOPIC, "Create a new todo");
        return todoRepository.save(todo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable Long id, @RequestBody Todo todoDetails) {
        Optional<Todo> todo = todoRepository.findById(id);
        if (todo.isPresent()) {
            Todo _todo = todo.get();
            _todo.setTitle(todoDetails.getTitle());
            _todo.setDescription(todoDetails.getDescription());
            _todo.setCompleted(todoDetails.isCompleted());
            kafkaTemplate.send(TOPIC, "Update a todo with ID " + id);
            return ResponseEntity.ok(todoRepository.save(_todo));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable Long id) {
        if (todoRepository.existsById(id)) {
            todoRepository.deleteById(id);
            kafkaTemplate.send(TOPIC, "Delete a todo with ID " + id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
