package com.FibNum2025Oct19;

public class FibonacciGenerator {

    private final FibonacciCalculator fibonacciCalculator;

    public FibonacciGenerator() {
        fibonacciCalculator = new IterativeFibonacciCalculator() ;
    }

    public FibonacciGenerator(FibonacciCalculator fibonacciCalculator) {
        this.fibonacciCalculator = fibonacciCalculator ;
    }

    public int getFibNum(int index) {

        CheckIndex checkIndex = new CheckIndex();
        checkIndex.ifValid(index);

        return fibonacciCalculator.calculate(index);
    }
}

