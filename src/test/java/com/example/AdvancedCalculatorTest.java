package com.example;

import org.testng.annotations.*;
import org.testng.Assert;

public class AdvancedCalculatorTest {

    private Calculator calculator;

    @BeforeMethod
    public void setUp() {
        System.out.println("🔧 Setting up calculator for advanced test");
        System.out.println("  🔢 Testing new feature");
        System.out.println("  🔢 Testing new feature test2");
        calculator = new Calculator();
    }

    @Test
    public void testFactorial() {
        System.out.println("  🔢 Testing factorial");
        Assert.assertEquals(calculator.factorial(5), 120, "5! should be 120");
        Assert.assertEquals(calculator.factorial(0), 1, "0! should be 1");
    }

    @Test
    public void testFactorialNegative() {
        System.out.println("  🔢 Testing factorial with negative (should throw)");
        try {
            calculator.factorial(-5);
            Assert.fail("Should have thrown exception");
        } catch (IllegalArgumentException e) {
            Assert.assertEquals(e.getMessage(), "Number must be positive");
        }
    }

    @Test
    public void testComplexOperation() {
        System.out.println("  🔢 Testing complex operation");
        int result = calculator.add(calculator.multiply(2, 3), 4);
        Assert.assertEquals(result, 10, "2*3 + 4 should be 10");
    }

    @DataProvider(name = "additionData")
    public Object[][] provideAdditionData() {
        return new Object[][] {
                {1, 2, 3},
                {5, 5, 10},
                {10, -3, 7},
                {0, 0, 0}
        };
    }

    @Test(dataProvider = "additionData")
    public void testAddWithDataProvider(int a, int b, int expected) {
        System.out.println("  🔢 Testing add with data: " + a + " + " + b + " = " + expected);
        Assert.assertEquals(calculator.add(a, b), expected);
    }
}