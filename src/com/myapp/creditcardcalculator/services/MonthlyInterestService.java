package com.myapp.creditcardcalculator.services;

import com.myapp.creditcardcalculator.interfaces.CalculateInterestService;

public class MonthlyInterestService implements CalculateInterestService {

    public double calculateInterest(double principal, double rate) {
        int time = 1;
        return (principal * rate * time) / 100;
    }
}
