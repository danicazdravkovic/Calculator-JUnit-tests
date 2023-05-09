/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.automatizacija.calculator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 *
 * @author nodas
 */
public class CalculatorTest {

    public CalculatorTest() {
    }
    private Calculator calculator = new Calculator();

    @Test
    public void testAdd() {
        int result = calculator.add(2, 3);
        assertEquals(5, result);
    }

    @Test
    public void testSubtract() {
        int result = calculator.subtract(5, 3);
        assertEquals(2, result);
    }

    @ParameterizedTest(name = "Multiplying {0} and {1} result is {2}")
    @CsvSource({"4,2,8", "-4,2,-8", "4,-2,-8", "-4,-2,8"})
    public void testMultiply(int num1, int num2, int res) {
        int result = calculator.multiply(num1, num2);
        assertEquals(res, result);
    }

    @ParameterizedTest(name = "Dividing {0} and {1} result is {2}")
    @CsvSource({"4,2,2", "-4,2,-2", "4,-2,-2", "-4,-2,2"})
    public void testDivide(int num1, int num2, int res) throws Exception {
        int result = calculator.divide(num1, num2);
        assertEquals(res, result);
    }

    @Test
    public void testDivideByZero() throws Exception {
        Exception e=assertThrows(Exception.class, ()->{
            calculator.divide(3, 0);
        });
        assertEquals("Can't divide by zero", e.getMessage());
    }
}
