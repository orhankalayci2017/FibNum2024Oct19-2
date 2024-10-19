import com.FibNum2025Oct19.FibonacciGenerator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FibonacciGeneratorTest {

    private final FibonacciGenerator fibonacciGenerator = new FibonacciGenerator();

    @Test
    public void testFibonacciOfZero() {
        assertEquals(0, fibonacciGenerator.getFibNum(0), "Fibonacci of 0 should be 0");
    }

    @Test
    public void testFibonacciOfOne() {
        assertEquals(1, fibonacciGenerator.getFibNum(1), "Fibonacci of 1 should be 1");
    }

    @Test
    public void testFibonacciOfTwo() {
        assertEquals(1, fibonacciGenerator.getFibNum(2), "Fibonacci of 2 should be 1");
    }

    @Test
    public void testFibonacciOfThree() {
        assertEquals(2, fibonacciGenerator.getFibNum(3), "Fibonacci of 2 should be 1");
    }
}