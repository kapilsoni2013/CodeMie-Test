package com.example.demo.service;

import com.example.demo.dto.TodoDTO;
import com.example.demo.entity.Todo;
import com.example.demo.repository.TodoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TodoServiceTest {

    @Mock
    private TodoRepository todoRepository;

    @InjectMocks
    private TodoService todoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void test_createTodo_withValidData_shouldReturnCreatedTodo() {
        TodoDTO todoDTO = new TodoDTO("Test Title", "Test Description", false);
        Todo todo = new Todo();
        todo.setTitle(todoDTO.getTitle());
        todo.setDescription(todoDTO.getDescription());
        todo.setCompleted(todoDTO.getCompleted());

        when(todoRepository.save(todo)).thenReturn(todo);

        Todo createdTodo = todoService.createTodo(todoDTO);

        assertEquals(todoDTO.getTitle(), createdTodo.getTitle());
        assertEquals(todoDTO.getDescription(), createdTodo.getDescription());
        assertEquals(todoDTO.getCompleted(), createdTodo.getCompleted());
    }
}
