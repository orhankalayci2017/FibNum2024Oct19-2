import com.FibNum2025Oct19.FibonacciGenerator;
import com.FibNum2025Oct19.IterativeFibonacciCalculator;
import com.FibNum2025Oct19.RecursiveFibonacciCalculator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class FibonacciGeneratorTest {

    // Method that provides both iterative and recursive generators
    private static Stream<FibonacciGenerator> provideFibonacciStrategies() {
        return Stream.of(
                new FibonacciGenerator(new IterativeFibonacciCalculator()),
                new FibonacciGenerator(new RecursiveFibonacciCalculator())
        );
    }

    @ParameterizedTest
    @MethodSource("provideFibonacciStrategies")
    public void testFibonacci(FibonacciGenerator fibonacciGenerator) {
        assertEquals(0, fibonacciGenerator.getFibNum(0), "Fibonacci of 0 should be 0");
        assertEquals(1, fibonacciGenerator.getFibNum(1), "Fibonacci of 1 should be 1");
        assertEquals(1, fibonacciGenerator.getFibNum(2), "Fibonacci of 2 should be 1");
        assertEquals(2, fibonacciGenerator.getFibNum(3), "Fibonacci of 3 should be 2");
        assertEquals(3, fibonacciGenerator.getFibNum(4), "Fibonacci of 4 should be 3");
        assertEquals(5, fibonacciGenerator.getFibNum(5), "Fibonacci of 5 should be 5");
        assertEquals(8, fibonacciGenerator.getFibNum(6), "Fibonacci of 6 should be 8");
    }

    @Test
    @Timeout(value = 200, unit = TimeUnit.MILLISECONDS)  // Timeout after 200 ms
    public void testFibonacciTimeoutFor44() {
        FibonacciGenerator fibonacciGenerator = new FibonacciGenerator(new IterativeFibonacciCalculator());
        int expected = 701408733;  // The expected value of F(44)
        assertEquals(expected, fibonacciGenerator.getFibNum(44));
    }

    @ParameterizedTest
    @MethodSource("provideFibonacciStrategies")
    public void testNegativeIndices(FibonacciGenerator fibonacciGenerator) {
        int[] negativeIndices = {-1, -5, -10};  // Array of negative indices to test

        for (int index : negativeIndices) {
            try {
                fibonacciGenerator.getFibNum(index);  // Pass a negative index
                fail("Expected IllegalArgumentException to be thrown for index: " + index);  // Fail if no exception is thrown
            } catch (IllegalArgumentException e) {
                assertEquals("Index cannot be negative", e.getMessage());  // Check the error message
            }
        }
    }

    @ParameterizedTest
    @MethodSource("provideFibonacciStrategies")
    public void testMaximumIndices(FibonacciGenerator fibonacciGenerator) {
        int[] tooBigIndices = {46, 50, 99};  // Array of negative indices to test

        for (int index : tooBigIndices) {
            try {
                fibonacciGenerator.getFibNum(index);  // Pass a negative index
                fail("Expected IllegalArgumentException to be thrown for index: " + index);  // Fail if no exception is thrown
            } catch (IllegalArgumentException e) {
                assertEquals("Index cannot exceed the Maximum Index (45)", e.getMessage());  // Check the error message
            }
        }
    }
}