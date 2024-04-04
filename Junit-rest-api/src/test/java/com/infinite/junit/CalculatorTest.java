package com.infinite.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import com.infinite.junit.first.Calculator;

public class CalculatorTest {
	
	Calculator calculator;
	
	@BeforeEach
	public void setUp() {
		calculator = new Calculator();
	}
	
	@Test
	public void testMultiply1() {
		calculator = new Calculator();
		assertEquals(20, calculator.multiply(4, 5));
	}
	
	@Test
	public void testMultiply2() {
		calculator = new Calculator();
		assertEquals(25, calculator.multiply(5, 5));
	}
	
	@Test
	public void testDivide1() {
		calculator = new Calculator();
		assertEquals(5, calculator.divide(25, 5));
	}
	
	@Test
	public void testDivide2() {
		calculator = new Calculator();
		assertEquals(0, calculator.divide(25, 0));
	}

}
