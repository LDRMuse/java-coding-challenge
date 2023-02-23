package com.myapp.creditcardcalculator.services;

import com.myapp.creditcardcalculator.interfaces.CalculateInterestService;

public class MonthlyInterestService implements CalculateInterestService {

    public double calculateInterest(double cardBalance, double interestRate) {
        int month = 1;
        return (cardBalance * interestRate * month) / 100;
    }
}
