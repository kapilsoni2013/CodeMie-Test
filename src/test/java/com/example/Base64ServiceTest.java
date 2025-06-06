package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class Base64ServiceTest {

    private Base64Service base64Service;

    @BeforeEach
    void setUp() {
        base64Service = new Base64Service();
    }

    @Test
    void test_encodeString_withValidInput_shouldReturnEncodedString() {
        String input = "Hello World";
        String expectedOutput = "SGVsbG8gV29ybGQ=";
        String actualOutput = base64Service.encodeString(input);
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void test_encodeString_withEmptyInput_shouldReturnEmptyString() {
        String input = "";
        String expectedOutput = "";
        String actualOutput = base64Service.encodeString(input);
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void test_encodeString_withNullInput_shouldThrowInvalidInputException() {
        assertThrows(InvalidInputException.class, () -> base64Service.encodeString(null));
    }
}
