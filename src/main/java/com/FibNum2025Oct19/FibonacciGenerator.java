package com.FibNum2025Oct19;

public class FibonacciGenerator {

    FibonacciCalculator fibonacciCalculator = new IterativeFibonacciCalculator() ;

    public int getFibNum(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("Index cannot be negative");
        }
        return fibonacciCalculator.calculate(index);
    }
}

