package com.FibNum2025Oct19;

public class FibonacciGenerator {

    private FibonacciCalculator fibonacciCalculator;

    public FibonacciGenerator() {
        fibonacciCalculator = new IterativeFibonacciCalculator() ;
    }

    public FibonacciGenerator(FibonacciCalculator fibonacciCalculator) {
        this.fibonacciCalculator = fibonacciCalculator ;
    }

    public void setFibonacciCalculator(FibonacciCalculator fibonacciCalculator) {
        this.fibonacciCalculator = fibonacciCalculator;
    }

    public int getFibNum(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("Index cannot be negative");
        }
        return fibonacciCalculator.calculate(index);
    }
}

