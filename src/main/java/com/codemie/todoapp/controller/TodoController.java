package com.codemie.todoapp.controller;

import com.codemie.todoapp.model.Todo;
import com.codemie.todoapp.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TodoController {

    @Autowired
    private TodoRepository todoRepository;

    @GetMapping("/")
    public String index(Model model) {
        List<Todo> todos = todoRepository.findAll();
        model.addAttribute("todos", todos);
        return "index";
    }

    @PostMapping("/add")
    public String addTodo(@RequestParam String title) {
        Todo todo = new Todo();
        todo.setTitle(title);
        todoRepository.save(todo);
        return "redirect:/";
    }

    @PostMapping("/delete")
    public String deleteTodo(@RequestParam Long id) {
        todoRepository.deleteById(id);
        return "redirect:/";
    }
}
