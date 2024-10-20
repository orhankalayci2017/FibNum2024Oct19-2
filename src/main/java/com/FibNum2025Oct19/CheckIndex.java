package com.FibNum2025Oct19;

public class CheckIndex{
    
    public void ifValid(int index) {
        
        if (index < 0) {
            throw new IllegalArgumentException("Index cannot be negative");
        }

        if (index > 45) {
            throw new IllegalArgumentException("Index cannot exceed the Maximum Index (45)");
        }
    }
}
