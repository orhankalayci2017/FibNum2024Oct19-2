package com.FibNum2025Oct19;

public class RecursiveFibonacciCalculator implements FibonacciCalculator {

    @Override
    public int calculate(int index) {
        if (index == 0) return 0;
        if (index == 1) return 1;
        return calculate(index - 1) + calculate(index - 2);
    }
}
