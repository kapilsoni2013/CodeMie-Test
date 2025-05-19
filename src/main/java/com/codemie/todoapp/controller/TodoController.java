package com.codemie.todoapp.controller;

import com.codemie.todoapp.model.Todo;
import com.codemie.todoapp.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TodoController {

    @Autowired
    private TodoRepository todoRepository;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("todos", todoRepository.findAll());
        model.addAttribute("todo", new Todo());
        return "index";
    }

    @PostMapping("/addTodo")
    public String addTodo(@ModelAttribute Todo todo) {
        todoRepository.save(todo);
        return "redirect:/";
    }

    @GetMapping("/deleteTodo/{id}")
    public String deleteTodo(@PathVariable Long id) {
        todoRepository.deleteById(id);
        return "redirect:/";
    }

}