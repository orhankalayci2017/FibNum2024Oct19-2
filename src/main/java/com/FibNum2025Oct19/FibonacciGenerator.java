package com.FibNum2025Oct19;

public class FibonacciGenerator {
    public int getFibNum(int i) {
        if (i ==0) return 0;
        if (i ==1) return 1;
        return getFibNum(i-1) + getFibNum(i-2);
    }
}
