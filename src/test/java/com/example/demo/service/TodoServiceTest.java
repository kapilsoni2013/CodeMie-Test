package com.example.demo.service;

import com.example.demo.dto.TodoDTO;
import com.example.demo.entity.Todo;
import com.example.demo.repository.TodoRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class TodoServiceTest {

    @Mock
    private TodoRepository todoRepository;

    @InjectMocks
    private TodoService todoService;

    @Test
    void test_createTodo_withValidData_shouldReturnCreatedTodo() {
        TodoDTO todoDTO = new TodoDTO("Test Title", "Test Description", false);
        Todo todo = new Todo();
        todo.setTitle("Test Title");
        todo.setDescription("Test Description");
        todo.setCompleted(false);

        Todo savedTodo = new Todo();
        savedTodo.setId(1L);
        savedTodo.setTitle("Test Title");
        savedTodo.setDescription("Test Description");
        savedTodo.setCompleted(false);

        Mockito.when(todoRepository.save(Mockito.any(Todo.class))).thenReturn(savedTodo);

        Todo createdTodo = todoService.createTodo(todoDTO);

        assertEquals(savedTodo.getId(), createdTodo.getId());
        assertEquals(savedTodo.getTitle(), createdTodo.getTitle());
        assertEquals(savedTodo.getDescription(), createdTodo.getDescription());
        assertEquals(savedTodo.getCompleted(), createdTodo.getCompleted());
    }
}
