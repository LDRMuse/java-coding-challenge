package com.myapp.creditcardcalculator.models;

import com.myapp.creditcardcalculator.interfaces.CalculateInterestService;
import com.myapp.creditcardcalculator.interfaces.Card;
import com.myapp.creditcardcalculator.services.PropertiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class Visa implements Card {
    PropertiesService propertiesService = new PropertiesService();

    @Autowired
    private CalculateInterestService monthlyInterestService;

    @Autowired
    public Visa(CalculateInterestService theCalculateInterest) {
        monthlyInterestService = theCalculateInterest; }


    public double getInterestRate() {
        return Double.parseDouble(propertiesService.getVisaInterest());
    }



    public double getPrincipal() {
        return 100;
    }

    @Override
    public double calculateInterest() {
       return monthlyInterestService.calculateInterest(getPrincipal(), getInterestRate());
    }

    @Override
    public String nameOfCard() {
        return "Visa";
    }


}
