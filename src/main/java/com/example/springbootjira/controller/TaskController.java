package com.example.springbootjira.controller;

import com.example.springbootjira.model.Task;
import com.example.springbootjira.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/create-task")
    public String showTaskForm(Model model) {
        model.addAttribute("task", new Task());
        return "create-task";
    }

    @PostMapping("/create-task")
    public String createTask(@ModelAttribute("task") Task task) {
        taskService.saveTask(task);
        return "redirect:/task-created";
    }
}
