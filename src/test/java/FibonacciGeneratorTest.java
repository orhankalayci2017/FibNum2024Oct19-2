import com.FibNum2025Oct19.FibonacciGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FibonacciGeneratorTest {

    private final FibonacciGenerator fibonacciGenerator = new FibonacciGenerator();

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
    public void testNegativeIndexThrowsException() {
        // Test that passing a negative index throws IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> {
            fibonacciGenerator.getFibNum(-5);  // Using a negative index
        });

        assertThrows(IllegalArgumentException.class, () -> {
            fibonacciGenerator.getFibNum(-1);  // Using a negative index
        });

        assertThrows(IllegalArgumentException.class, () -> {
            fibonacciGenerator.getFibNum(-99);  // Using a negative index
        });
    }

}