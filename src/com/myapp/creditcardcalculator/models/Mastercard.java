package com.myapp.creditcardcalculator.models;

import com.myapp.creditcardcalculator.interfaces.CalculateInterestService;
import com.myapp.creditcardcalculator.interfaces.Card;
import com.myapp.creditcardcalculator.services.PropertiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class Mastercard implements Card {

    PropertiesService propertiesService = new PropertiesService();

    @Autowired
    private CalculateInterestService monthlyInterestService;

    public Mastercard(CalculateInterestService theCalculateInterest) {
        monthlyInterestService = theCalculateInterest;
    }

    public double getInterestRate() {
        return Double.parseDouble(propertiesService.getMastercardInterest());
    }

    public double getCardBalance() {
        return 100;

    }

    @Override
    public double calculateInterest() {
        return monthlyInterestService.calculateInterest(getCardBalance(), getInterestRate());
    }

    @Override
    public String nameOfCard() {
        return "Mastercard";
    }

}
