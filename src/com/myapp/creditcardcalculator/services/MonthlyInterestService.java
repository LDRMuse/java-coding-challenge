package com.myapp.creditcardcalculator.services;

import com.myapp.creditcardcalculator.interfaces.CalculateInterestService;

public class MonthlyInterestService implements CalculateInterestService {

    public double calculateInterest(double principal, double rate) {
        int month = 1;
        return (principal * rate * month) / 100;
    }
}
