import com.FibNum2025Oct19.FibonacciGenerator;
import com.FibNum2025Oct19.IterativeFibonacciCalculator;
import com.FibNum2025Oct19.RecursiveFibonacciCalculator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class FibonacciGeneratorTest {

    private final FibonacciGenerator fibonacciGenerator = new FibonacciGenerator(new IterativeFibonacciCalculator());

    @ParameterizedTest
    @CsvSource({
            "0, 0",   // F(0) = 0
            "1, 1",   // F(1) = 1
            "2, 1",   // F(2) = 1
            "3, 2",   // F(3) = 2
            "4, 3",   // F(4) = 3
            "5, 5",   // F(5) = 5
            "6, 8"    // F(6) = 8 (just an additional case for extended testing)
    })
    public void testFibonacci(int index, int expected) {
        assertEquals(expected, fibonacciGenerator.getFibNum(index),
                "Fibonacci of " + index + " should be " + expected);
    }

    @Test
    @Timeout(value = 200, unit = TimeUnit.MILLISECONDS)  // Timeout after 200 ms
    public void testFibonacciTimeoutFor44() {
        int expected = 701408733;  // The expected value of F(44)
        assertEquals(expected, fibonacciGenerator.getFibNum(44));
    }

    @Test
    public void testNegativeIndices() {
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
}