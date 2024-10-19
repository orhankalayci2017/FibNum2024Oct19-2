package com.FibNum2025Oct19;

public class FibonacciGenerator {
    public int getFibNum(int i) {
        return iterativeMethod(i) ;
    }

    private int recursiveMethod (int i) {
        if (i ==0) return 0;
        if (i ==1) return 1;
        return getFibNum(i-1) + getFibNum(i-2);
    }
    private int iterativeMethod (int index) {
        if (index ==0) return 0;
        if (index ==1) return 1;


            // Use an iterative approach to compute Fibonacci numbers
            int previous = 0;  // F(n-2)
            int current = 1;   // F(n-1)
            int fibonacci = 1; // F(n)

            for (int i = 2; i <= index; i++) {
                fibonacci = previous + current;  // F(n) = F(n-1) + F(n-2)
                previous = current;              // Update F(n-2) for next iteration
                current = fibonacci;             // Update F(n-1) for next iteration
            }

            return fibonacci;
        }
    }

