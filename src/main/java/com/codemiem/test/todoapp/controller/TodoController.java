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
    public String viewHomePage(Model model) {
        List<Todo> listTodos = todoRepository.findAll();
        model.addAttribute("listTodos", listTodos);
        return "index";
    }

    @PostMapping("/save")
    public String saveTodo(@RequestParam("title") String title,
                           @RequestParam("description") String description) {
        Todo todo = new Todo();
        todo.setTitle(title);
        todo.setDescription(description);
        todoRepository.save(todo);
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String deleteTodo(@RequestParam("id") Long id) {
        todoRepository.deleteById(id);
        return "redirect:/";
    }
}