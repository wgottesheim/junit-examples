
// Calculator Controller Tests
package com.wogo.calc.controller;

import com.wogo.calc.service.CalculatorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CalculatorController.class)
class CalculatorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CalculatorService calculatorService;

    @BeforeEach
    void setUp() {
        when(calculatorService.add(2, 3)).thenReturn(5);
        when(calculatorService.subtract(3, 2)).thenReturn(1);
        when(calculatorService.multiply(2, 3)).thenReturn(6);
        when(calculatorService.divide(6, 3)).thenReturn(2);
    }

    @Test
    void add_ShouldReturnSum() throws Exception {
        mockMvc.perform(get("/calculator/add").param("a", "2").param("b", "3"))
                .andExpect(status().isOk())
                .andExpect(content().string("5"));
    }

    @Test
    void subtract_ShouldReturnDifference() throws Exception {
        mockMvc.perform(get("/calculator/subtract").param("a", "3").param("b", "2"))
                .andExpect(status().isOk())
                .andExpect(content().string("1"));
    }

    @Test
    void multiply_ShouldReturnProduct() throws Exception {
        mockMvc.perform(get("/calculator/multiply").param("a", "2").param("b", "3"))
                .andExpect(status().isOk())
                .andExpect(content().string("6"));
    }

    @Test
    void divide_ShouldReturnQuotient() throws Exception {
        mockMvc.perform(get("/calculator/divide").param("a", "6").param("b", "3"))
                .andExpect(status().isOk())
                .andExpect(content().string("2"));
    }

    @Test
    void divide_ShouldReturnBadRequestWhenDividingByZero() throws Exception {
        mockMvc.perform(get("/calculator/divide").param("a", "1").param("b", "0"))
                .andExpect(status().isBadRequest());
    }
}