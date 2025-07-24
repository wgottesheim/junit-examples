// Calculator Service Tests
package com.wogo.calc.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.wogo.calc.service.CalculatorService;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceTest {

    private CalculatorService calculatorService;

    @BeforeEach
    void setUp() {
        calculatorService = new CalculatorService();
    }

    @Test
    void add_ShouldReturnSum() {
        assertEquals(5, calculatorService.add(2, 3));
    }

    @Test
    void subtract_ShouldReturnDifference() {
        assertEquals(1, calculatorService.subtract(3, 2));
    }

    @Test
    void multiply_ShouldReturnProduct() {
        assertEquals(6, calculatorService.multiply(2, 3));
    }

    @Test
    void divide_ShouldReturnQuotient() {
        assertEquals(2, calculatorService.divide(6, 3));
    }

    @Test
    void divide_ShouldThrowExceptionWhenDividingByZero() {
        assertThrows(ArithmeticException.class, () -> calculatorService.divide(1, 0));
    }
}