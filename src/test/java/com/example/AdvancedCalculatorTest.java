package com.example;

import org.testng.annotations.*;
import org.testng.Assert;

@Test(groups = {"advanced", "unit"})
public class AdvancedCalculatorTest {

    private Calculator calculator;

    @BeforeClass
    public void beforeClass() {
        System.out.println("🚀 Starting Advanced Calculator Tests");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("✅ Completed Advanced Calculator Tests");
    }

    @BeforeMethod
    public void setUp() {
        calculator = new Calculator();
    }

    @Test(groups = {"factorial", "smoke"})
    public void testFactorial() {
        System.out.println("  🔢 Testing factorial");
        Assert.assertEquals(calculator.factorial(5), 120, "5! should be 120");
        Assert.assertEquals(calculator.factorial(0), 1, "0! should be 1");
    }

    @Test(groups = {"factorial", "error-handling"},
            expectedExceptions = IllegalArgumentException.class)
    public void testFactorialNegative() {
        System.out.println("  🔢 Testing factorial with negative (should throw)");
        calculator.factorial(-5);
    }

    @Test(groups = {"multiple-operations"},
            dependsOnMethods = {"testAdd", "testMultiply"})
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

    @Test(groups = {"data-driven"}, dataProvider = "additionData")
    public void testAddWithDataProvider(int a, int b, int expected) {
        System.out.println("  🔢 Testing add with data: " + a + " + " + b + " = " + expected);
        Assert.assertEquals(calculator.add(a, b), expected);
    }
}