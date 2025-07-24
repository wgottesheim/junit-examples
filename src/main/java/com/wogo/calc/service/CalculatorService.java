
// Calculator Service
package com.wogo.calc.service;

import org.springframework.stereotype.Service;

import com.wogo.calc.Calculator;

@Service
public class CalculatorService {

    private final Calculator calculator;

    public CalculatorService() {
        this.calculator = new Calculator();
    }

    public int add(int a, int b) {
        return calculator.add(a, b);
    }

    public int subtract(int a, int b) {
        return calculator.subtract(a, b);
    }

    public int multiply(int a, int b) {
        return calculator.multiply(a, b);
    }

    public int divide(int a, int b) {
        return calculator.divide(a, b);
    }
}
