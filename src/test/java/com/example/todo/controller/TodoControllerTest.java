package com.example.todo.controller;

import com.example.todo.model.Todo;
import com.example.todo.repository.TodoRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@EmbeddedKafka(partitions = 1, topics = {"todo-topic"}, brokerProperties = {"listeners=PLAINTEXT://localhost:9092", "port=9092"})
class TodoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TodoRepository todoRepository;

    @Test
    void shouldFetchAllTodos() throws Exception {
        Todo todo1 = new Todo();
        todo1.setTitle("Todo 1");
        todo1.setDescription("Description 1");
        todo1.setCompleted(false);

        Todo todo2 = new Todo();
        todo2.setTitle("Todo 2");
        todo2.setDescription("Description 2");
        todo2.setCompleted(false);

        Mockito.when(todoRepository.findAll()).thenReturn(Arrays.asList(todo1, todo2));

        mockMvc.perform(get("/api/todos"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].title", is(todo1.getTitle())))
                .andExpect(jsonPath("$[1].title", is(todo2.getTitle())));
    }

    @Test
    void shouldFetchTodoById() throws Exception {
        Todo todo = new Todo();
        todo.setTitle("Test Todo");
        todo.setDescription("Test Description");
        todo.setCompleted(false);

        Mockito.when(todoRepository.findById(1L)).thenReturn(Optional.of(todo));

        mockMvc.perform(get("/api/todos/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title", is(todo.getTitle())));
    }

    @Test
    void shouldCreateNewTodo() throws Exception {
        Todo todo = new Todo();
        todo.setTitle("New Todo");
        todo.setDescription("New Description");
        todo.setCompleted(false);

        Mockito.when(todoRepository.save(Mockito.any(Todo.class))).thenReturn(todo);

        mockMvc.perform(post("/api/todos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{"title": "New Todo", "description": "New Description", "completed": false}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title", is(todo.getTitle())));
    }

    @Test
    void shouldUpdateTodo() throws Exception {
        Todo todo = new Todo();
        todo.setTitle("Updated Todo");
        todo.setDescription("Updated Description");
        todo.setCompleted(true);

        Mockito.when(todoRepository.findById(1L)).thenReturn(Optional.of(todo));
        Mockito.when(todoRepository.save(Mockito.any(Todo.class))).thenReturn(todo);

        mockMvc.perform(put("/api/todos/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{"title": "Updated Todo", "description": "Updated Description", "completed": true}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title", is(todo.getTitle())));
    }

    @Test
    void shouldDeleteTodo() throws Exception {
        Mockito.when(todoRepository.existsById(1L)).thenReturn(true);

        mockMvc.perform(delete("/api/todos/1"))
                .andExpect(status().isOk());
    }
}
