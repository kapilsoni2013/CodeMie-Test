package com.example.demo.service;

import com.example.demo.dto.request.TaskRequest;
import com.example.demo.dto.response.TaskResponse;
import com.example.demo.entity.Task;
import com.example.demo.exception.TaskNotFoundException;
import com.example.demo.repository.TaskRepository;
import com.example.demo.service.impl.TaskServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TaskServiceTest {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskServiceImpl taskService;

    public TaskServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldCreateTask() {
        TaskRequest request = new TaskRequest();
        request.setTitle("Test Task");
        request.setDescription("Test Description");
        request.setCompleted(false);

        Task task = new Task();
        task.setId(1L);
        task.setTitle("Test Task");
        task.setDescription("Test Description");
        task.setCompleted(false);

        when(taskRepository.save(any(Task.class))).thenReturn(task);

        TaskResponse response = taskService.createTask(request);

        assertNotNull(response);
        assertEquals(1L, response.getId());
        assertEquals("Test Task", response.getTitle());
        assertEquals("Test Description", response.getDescription());
        assertFalse(response.isCompleted());
    }

    @Test
    void shouldThrowExceptionWhenTaskNotFound() {
        when(taskRepository.findById(anyLong())).thenReturn(Optional.empty());

        assertThrows(TaskNotFoundException.class, () -> taskService.getTaskById(1L));
    }
}
