package com.example;

import org.testng.annotations.*;
import org.testng.Assert;

@Test(groups = {"unit", "smoke"})
public class CalculatorTest {

    private Calculator calculator;

    @BeforeMethod
    public void setUp() {
        System.out.println("📝 Setting up calculator before test");
        calculator = new Calculator();
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("🧹 Cleaning up after test");
        calculator = null;
    }

    @Test(groups = {"smoke", "addition"})
    public void testAdd() {
        System.out.println("  🔢 Testing addition");
        int result = calculator.add(5, 3);
        Assert.assertEquals(result, 8, "5 + 3 should be 8");
    }

    @Test(groups = {"smoke", "subtraction"})
    public void testSubtract() {
        System.out.println("  🔢 Testing subtraction");
        int result = calculator.subtract(10, 4);
        Assert.assertEquals(result, 6, "10 - 4 should be 6");
    }

    @Test(groups = {"multiplication"})
    public void testMultiply() {
        System.out.println("  🔢 Testing multiplication");
        int result = calculator.multiply(6, 7);
        Assert.assertEquals(result, 42, "6 * 7 should be 42");
    }

    @Test(groups = {"division"})
    public void testDivide() {
        System.out.println("  🔢 Testing division");
        int result = calculator.divide(15, 3);
        Assert.assertEquals(result, 5, "15 / 3 should be 5");
    }

    @Test(groups = {"division", "error-handling"},
            expectedExceptions = IllegalArgumentException.class)
    public void testDivideByZero() {
        System.out.println("  🔢 Testing division by zero (should throw exception)");
        calculator.divide(10, 0);
    }

    @Test(groups = {"even-odd"})
    public void testIsEven() {
        System.out.println("  🔢 Testing even/odd");
        Assert.assertTrue(calculator.isEven(4), "4 should be even");
        Assert.assertFalse(calculator.isEven(7), "7 should be odd");
    }
}