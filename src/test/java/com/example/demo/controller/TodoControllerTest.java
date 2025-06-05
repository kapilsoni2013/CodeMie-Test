package com.example.demo.controller;

import com.example.demo.dto.TodoDTO;
import com.example.demo.entity.Todo;
import com.example.demo.service.TodoService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

@WebMvcTest(TodoController.class)
class TodoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TodoService todoService;

    @Test
    void test_createTodo_withValidData_shouldReturnCreatedTodo() throws Exception {
        TodoDTO todoDTO = new TodoDTO("Test Title", "Test Description", false);
        Todo createdTodo = new Todo();
        createdTodo.setId(1L);
        createdTodo.setTitle("Test Title");
        createdTodo.setDescription("Test Description");
        createdTodo.setCompleted(false);

        Mockito.when(todoService.createTodo(Mockito.any(TodoDTO.class))).thenReturn(createdTodo);

        mockMvc.perform(MockMvcRequestBuilders.post("/todos")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{"title":"Test Title","description":"Test Description","completed":false}"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", is(notNullValue())))
                .andExpect(jsonPath("$.title", is("Test Title")))
                .andExpect(jsonPath("$.description", is("Test Description")))
                .andExpect(jsonPath("$.completed", is(false)));
    }

    @Test
    void test_createTodo_withInvalidData_shouldReturnValidationError() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/todos")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{"title":"","description":"","completed":false}"))
                .andExpect(status().isBadRequest());
    }
}
