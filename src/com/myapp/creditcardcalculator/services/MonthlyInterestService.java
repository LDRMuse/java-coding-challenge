package com.myapp.creditcardcalculator.services;

import com.myapp.creditcardcalculator.interfaces.CalculateInterestService;

public class MonthlyInterestService implements CalculateInterestService {
    @Override
    public double calculateInterest(double principal, double annualRate) {
        double monthlyRate = annualRate / 12.0;
        return (principal * monthlyRate) / 100.0;
    }
}
