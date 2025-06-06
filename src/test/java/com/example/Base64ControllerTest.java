package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(Base64Controller.class)
class Base64ControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private Base64Service base64Service;

    @Test
    void test_encodeStringEndpoint_withValidInput_shouldReturnEncodedString() throws Exception {
        String input = "Hello World";
        String expectedOutput = "SGVsbG8gV29ybGQ=";
        when(base64Service.encodeString(input)).thenReturn(expectedOutput);

        mockMvc.perform(post("/api/encode")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"input\":\"Hello World\"}"))
                .andExpect(status().isOk())
                .andExpect(content().string("{\"encoded\":\"SGVsbG8gV29ybGQ=\"}"));
    }

    @Test
    void test_encodeStringEndpoint_withEmptyInput_shouldReturnEmptyString() throws Exception {
        String input = "";
        String expectedOutput = "";
        when(base64Service.encodeString(input)).thenReturn(expectedOutput);

        mockMvc.perform(post("/api/encode")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"input\":\"\"}"))
                .andExpect(status().isOk())
                .andExpect(content().string("{\"encoded\":\"\"}"));
    }

    @Test
    void test_encodeStringEndpoint_withNullInput_shouldReturnBadRequest() throws Exception {
        when(base64Service.encodeString(null)).thenThrow(new InvalidInputException("Invalid input"));

        mockMvc.perform(post("/api/encode")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"input\":null}"))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("{\"error\":\"Invalid input\"}"));
    }
}
